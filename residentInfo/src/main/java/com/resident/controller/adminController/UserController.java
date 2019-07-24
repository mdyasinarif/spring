package com.resident.controller.adminController;


import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Police;
import com.resident.entity.user.Tenant;
import com.resident.entity.admin.User;
import com.resident.repo.adminRepo.RoleRepo;
import com.resident.repo.adminRepo.UserRepo;
import com.resident.repo.userRepo.HouseOwnerRepo;
import com.resident.repo.userRepo.PoilceRepo;
import com.resident.repo.userRepo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class UserController {


    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private PoilceRepo poilceRepo;
    @Autowired
    private TenantRepo tenantRepo;


    @GetMapping("add")
    public String showForm(User user, Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("add")
    public String save(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("usertype") String usertype) {

        if (bindingResult.hasErrors()) {
            return "sign-up";
        }

        if (usertype.equals("houseowner")) {
            this.repo.save(user);
            HouseOwner owner = new HouseOwner();

            User user1 = repo.findByPhone(user.getPhone());

            owner.setUser(user1);
            this.houseOwnerRepo.save(owner);
        } else if (usertype.equals("police")) {
            this.repo.save(user);
            Police police = new Police();

            User user1 = repo.findByPhone(user.getPhone());

            police.setUser(user1);
            this.poilceRepo.save(police);

        } else if (usertype.equals("tenant")) {
            this.repo.save(user);
            Tenant tenant = new Tenant();

            User user1 = repo.findByPhone(user.getPhone());

            tenant.setUser(user1);
            this.tenantRepo.save(tenant);
        }

        return "sign-up";
    }

    @GetMapping(value = "userlist")
    public String userList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "admin/userlist";
    }


    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.repo.getOne(id));
        return "admin/useredit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult,
                       @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "admin/useredit";
        }
        User oldUser = this.repo.getOne(id);
        this.repo.save(user);
        return "redirect:/user/userlist";
    }


    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/userlist";
    }


//
//    @PostMapping("/")
//    public String save(@Valid User user, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//        this.repo.save(user);
//
//        return "redirect:/results";
//    }
}
