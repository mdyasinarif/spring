package com.resident.controller.adminController.userController;

import com.resident.controller.adminController.ImageOptimizer;
import com.resident.entity.user.Tenant;
import com.resident.entity.user.Tenant;
import com.resident.repo.adminRepo.UserRepo;
import com.resident.repo.userRepo.EmployeeRepo;
import com.resident.repo.userRepo.FamilyMamberRepo;
import com.resident.repo.userRepo.TenantRepo;
import com.resident.repo.userRepo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/tenant/")
public class TenantController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;
    @Autowired
    private TenantRepo repo;
    
    @Autowired
    private TenantRepo tenantRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FamilyMamberRepo familyMamberRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "add")
    public String tenantView(Tenant tenant) {
        return "user/Tenant";

    }

    @PostMapping(value = "add")
    public String addTenant(@Valid Tenant tenant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add";
        } else {
            if (tenant != null) {
                Tenant tenant1 = this.repo.findByContractNo(tenant.getContractNo());
                if (tenant1 != null) {
                    model.addAttribute("existMsg", "Tenant is already exist");
                } else {
                    this.repo.save(tenant);
                    model.addAttribute("tenant", new Tenant());
                    model.addAttribute("successMsg", "Tenant save Successfully");
                }
            }
        }
        return "user/tenant";
    }

    @GetMapping(value = "tenantlist")
    public String ownerList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "user/tenantlist";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tenant", this.repo.getOne(id));
        return "user/tenantedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editTenant(@Valid Tenant tenant, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/tenantedit";
        } else {
            if (tenant != null) {
                Tenant tenant1 = this.repo.findByContractNo(tenant.getContractNo());
                if (tenant1 != null) {
                    model.addAttribute("existMsg", "Tenant is already exist");
                } else {
                    this.repo.save(tenant);
                    model.addAttribute("tenant", new Tenant());
                    model.addAttribute("successMsg", "Tenant Edit Successfully");
                }
            }
        }

        return "redirect:/user/tenantlist";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delTenant(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/tenantlist";

    }

}
