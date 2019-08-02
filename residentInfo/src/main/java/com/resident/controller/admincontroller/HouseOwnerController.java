package com.resident.controller.admincontroller;

import com.resident.entity.user.HouseOwner;
import com.resident.repo.ThanaRepo;
import com.resident.repo.UserRepo;
import com.resident.repo.BuillidingRepo;
import com.resident.repo.EmployeeRepo;
import com.resident.repo.FamilyMamberRepo;
import com.resident.repo.HouseOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/houseowner/")
public class HouseOwnerController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;
    @Autowired
    private HouseOwnerRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FamilyMamberRepo familyMamberRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ThanaRepo thanaRepo;
    @Autowired
    private BuillidingRepo buillidingRepo;


    @GetMapping(value = "list")
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("list", this.repo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
        //model.addAttribute("address", this.buillidingRepo.findByAdress(thanaRepo.findByName()));
        return "user/owner/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("houseOwner", this.repo.getOne(id));
        model.addAttribute("thanalist", this.thanaRepo.findAll());
        return "user/owner/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editHouseOwner(@Valid HouseOwner houseOwner, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/owner/edit";
        } else {
            HouseOwner houseOwner1 = this.repo.getOne(id);
            houseOwner.setUser(houseOwner1.getUser());
            houseOwner.setId(houseOwner1.getId());
            //file upload
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            houseOwner.setPhoto("/images/new-" + file.getOriginalFilename());
            // file upload end
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 100, 120);
            this.repo.save(houseOwner);
            model.addAttribute("thanalist", this.thanaRepo.findAll());
            model.addAttribute("successMsg", "HouseOwner Save Successfully");

        }


        return "redirect:/houseowner/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delHouseOwner(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/houseowner/list";

    }

}
