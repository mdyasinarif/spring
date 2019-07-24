package com.resident.controller.adminController.userController;

import com.resident.controller.adminController.ImageOptimizer;
import com.resident.entity.user.Police;
import com.resident.repo.adminRepo.UserRepo;
import com.resident.repo.userRepo.EmployeeRepo;
import com.resident.repo.userRepo.FamilyMamberRepo;

import com.resident.repo.userRepo.PoilceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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



    @GetMapping(value = "add")
    public String policeView(Police police) {
        return "user/Police";

    }

    @PostMapping(value = "add")
    public String addPolice(@Valid Police police, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add";
        } else {
            if (police != null) {
                Police police1 = this.repo.findByContractNo(police.getContractNo());
                if (police1 != null) {
                    model.addAttribute("existMsg", "Police is already exist");
                } else {
                    this.repo.save(police);
                    model.addAttribute("police", new Police());
                    model.addAttribute("successMsg", "Police save Successfully");
                }
            }
        }
        return "user/police";
    }

    @GetMapping(value = "policelist")
    public String ownerList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "user/policelist";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("police", this.repo.getOne(id));
        return "user/policeedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editPolice(@Valid Police police, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/policeedit";
        } else {
            if (police != null) {
                Police police1 = this.repo.findByContractNo(police.getContractNo());
                if (police1 != null) {
                    model.addAttribute("existMsg", "Police is already exist");
                } else {
                    this.repo.save(police);
                    model.addAttribute("police", new Police());
                    model.addAttribute("successMsg", "Police Edit Successfully");
                }
            }
        }

        return "redirect:/user/policelist";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delPolice(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/policelist";

    }

}
