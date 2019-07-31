package com.resident.controller.admincontroller.usercont;

import com.resident.controller.admincontroller.ImageOptimizer;
import com.resident.entity.user.Police;
import com.resident.repo.adddressrepo.ThanaRepo;
import com.resident.repo.adminrepo.UserRepo;

import com.resident.repo.userrepo.PoilceRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PoilceRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ThanaRepo thanaRepo;




    @GetMapping(value = "list")
    public String ownerList(Model model) {
        model.addAttribute("police", new Police());
        model.addAttribute("list", this.repo.findAll());
        return "user/police/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("police", this.repo.getOne(id));
        model.addAttribute("thanalist",this.thanaRepo.findAll());
        return "user/police/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editPolice(@Valid Police police, BindingResult result, @PathVariable("id") Long id, Model model,@RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/police/edit";
        } else {
            if (police != null) {
                Police police1 = this.repo.findByContractNo(police.getContractNo());
                if (police1 != null) {
                    model.addAttribute("existMsg", "Police is already exist");
                } else {

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
            }
        }

        return "redirect:/police/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delPolice(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/police/list";

    }

}
