package com.resident.controller.admincontroller;

import com.resident.entity.user.Police;
import com.resident.repo.*;

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
@RequestMapping(value = "/police/")
public class PoliceController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;
    @Autowired
    private PoliceRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ThanaRepo thanaRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private TenantRepo tenantRepo;

    @GetMapping(value = "list")
    public String policeList(Model model) {
        model.addAttribute("police", new Police());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("list", this.repo.findAllByUser(this.userRepo.findByUserName(auth.getName())));
        return "user/police/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("police", this.repo.getOne(id));
        model.addAttribute("thanalist", this.thanaRepo.findAll());
        return "user/police/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editPolice(@Valid Police police, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/police/edit";
        } else {
            Police police1 = this.repo.getOne(id);
            police.setUser(police1.getUser());
            police.setId(police1.getId());

            //file upload
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            police.setPhoto("/images/new-" + file.getOriginalFilename());
            // file upload end
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 100, 120);
            this.repo.save(police);

            model.addAttribute("successMsg", "Police Save Successfully");
        }


        return "redirect:/police/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delPolice(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/police/list";

    }

}
