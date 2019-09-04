package com.resident.controller;


import com.resident.entity.admin.Role;
import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
import com.resident.repo.BuildingRepo;
import com.resident.repo.FlatRepo;
import com.resident.repo.HouseOwnerRepo;
import com.resident.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/flat/")
public class FlatController {
    @Autowired
    private FlatRepo repo;
    @Autowired
    private BuildingRepo buildingRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private ImageOptimizer imageOptimizer;
    @Autowired
    private UserRepo userRepo;

    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @GetMapping(value = "add")
    public String addFlatView(Flat flat, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable <Building> blist = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            blist = this.buildingRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }
        model.addAttribute("buildinglist", blist);

        model.addAttribute("ownerlist",this.houseOwnerRepo.findAllByUser(this.userRepo.findByUserName(auth.getName())));



        return "user/flat/add";

    }

    @PostMapping(value = "add")
    public String addFlat(@Valid Flat flat, BindingResult result, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/flat/add";
        } else {
            if (flat != null) {
                Flat flat1 = this.repo.findByName(flat.getName());
                if (flat1 != null) {
                    model.addAttribute("existMsg", "FlatName is already exist");
                } else {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);
                    flat.setPhoto("/images/new-" + file.getOriginalFilename());
                    // file upload end
                    imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 100, 120);

                    flat.setStatus(true);
                    this.repo.save(flat);
                    model.addAttribute("flat", new Flat());
                    model.addAttribute("successMsg", "Flat save Successfully");
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

                    String rolename = null;
                    for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
                        rolename = r.getRoleName();
                    }
                    Iterable <Building> blist = null;
                    if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
                        blist = this.buildingRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
                    }
                    model.addAttribute("buildinglist", blist);

                    model.addAttribute("ownerlist",this.houseOwnerRepo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
                }
            }
        }
        return "user/flat/add";
    }

    @GetMapping(value = "list")
    public String buildingList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable <Building> list = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            list = this.buildingRepo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }

        model.addAttribute("list", list);

        return "user/flat/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editFlatView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("flat", this.repo.getOne(id));
        return "user/flat/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editFlat(@Valid Flat flat, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/flat/edit";
        } else {
            if (flat != null) {
                Flat flat1 = this.repo.findByName(flat.getName());
                if (flat1 != null) {
                    model.addAttribute("existMsg", "FlatName is already exist");
                    return "user/flat/edit";
                } else {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);
                    flat.setPhoto("/images/new-" + file.getOriginalFilename());
                    // file upload end
                    imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 100, 120);
                    this.repo.save(flat);
                    model.addAttribute("flat", new Flat());
                    model.addAttribute("successMsg", "FlatName save Success");
                }
            }
        }
        return "redirect:/user/flat/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delFlat(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/flat/list";

    }
}
