package com.resident.controller.adminController.userController;

import com.resident.controller.adminController.ImageOptimizer;
import com.resident.entity.admin.Role;
import com.resident.entity.user.HouseOwner;
import com.resident.repo.adminRepo.UserRepo;
import com.resident.repo.userRepo.EmployeeRepo;
import com.resident.repo.userRepo.FamilyMamberRepo;
import com.resident.repo.userRepo.HouseOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping(value = "add")
    public String houseOwnerView(HouseOwner houseOwner) {
        return "user/HouseOwner";

    }

    @PostMapping(value = "add")
    public String addHouseowner(@Valid HouseOwner houseOwner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add";
        } else {
            if (houseOwner != null) {
                HouseOwner houseOwner1 = this.repo.findByContractNo(houseOwner.getContractNo());
                if (houseOwner1 != null) {
                    model.addAttribute("existMsg", "HouseOwner is already exist");
                } else {
                    this.repo.save(houseOwner);
                    model.addAttribute("houseOwner", new HouseOwner());
                    model.addAttribute("successMsg", "HouseOwner save Successfully");
                }
            }
        }
        return "user/houseOwner";
    }

    @GetMapping(value = "ownerlist")
    public String ownerList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "user/ownerlist";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("houseOwner", this.repo.getOne(id));
        return "user/owneredit";

    }

    @PostMapping(value = "edit/{id}")
    public String editHouseOwner(@Valid HouseOwner houseOwner, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/owneredit";
        } else {
            if (houseOwner != null) {
                HouseOwner houseOwner1 = this.repo.findByContractNo(houseOwner.getContractNo());
                if (houseOwner1 != null) {
                    model.addAttribute("existMsg", "HouseOwner is already exist");
                } else {
                    this.repo.save(houseOwner);
                    model.addAttribute("houseOwner", new HouseOwner());
                    model.addAttribute("successMsg", "HouseOwner Edit Successfully");
                }
            }
        }

        return "redirect:/user/ownerlist";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delHouseOwner(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/ownerlist";

    }

}
