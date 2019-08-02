package com.resident.controller.admincontroller;

import com.resident.entity.user.Tenant;
import com.resident.repo.ThanaRepo;
import com.resident.repo.UserRepo;
import com.resident.repo.EmployeeRepo;
import com.resident.repo.FamilyMamberRepo;
import com.resident.repo.TenantRepo;
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

    @Autowired
    private ThanaRepo thanaRepo;

    @GetMapping(value = "list")
    public String ownerList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("thanalist",this.thanaRepo.findAll());
        return "user/tenant/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tenant", this.repo.getOne(id));
        model.addAttribute("thanalist",this.thanaRepo.findAll());
        return "user/tenant/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editTenant(@Valid Tenant tenant, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return "user/owner/edit";
        } else {
            Tenant tenant1 = this.repo.getOne(id);
            tenant.setUser(tenant1.getUser());
            tenant.setId(tenant1.getId());

                    //file upload
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);
                    tenant.setPhoto("/images/new-" + file.getOriginalFilename());
                    // file upload end
                    imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.8f, 100, 120);
                    this.repo.save(tenant);

                    model.addAttribute("successMsg", "Tenant Save Successfully");
                }

        return "redirect:/tenant/list";
    }
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delTenant(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/tenant/list";

    }

}
