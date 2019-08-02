package com.resident.controller.admincontroller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Police;
import com.resident.entity.user.Tenant;
import com.resident.repo.RoleRepo;
import com.resident.repo.UserRepo;
import com.resident.repo.HouseOwnerRepo;
import com.resident.repo.PoilceRepo;
import com.resident.repo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/user/")
public class UserController {


    @Autowired
    private UserRepo repo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private PoilceRepo poilceRepo;
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private RoleRepo roleRepo;

@Autowired
private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping(value = "/add")
    public String showForm(User user, Model model) {
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "sign-up";
    }

    @Transactional
    @PostMapping(value = "/add")
    public String displaySignup(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sign-up";
        } else {
            if (user != null) {
                User user1 = this.repo.findByUserName(user.getUserName());
                if (user1 != null) {
                    model.addAttribute("existMsg", "User is already exist");
                } else {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    this.repo.save(user);
                    String rolename = null;
                    for (Role r : user.getRoles()) {
                        rolename = r.getRoleName();
                    }
                    User user2 = this.repo.findByUserName(user.getUserName());
                    if (rolename.equalsIgnoreCase("HOUSEOWNER")) {

                        HouseOwner houseOwner = new HouseOwner("", "", "", "", "", new Date(), user.getPhone(), null, 0.0, 0, 0, "", user2);
                        this.houseOwnerRepo.save(houseOwner);
                    } else if (rolename.equalsIgnoreCase("POLICE")) {
                        Police police = new Police("", null, "", "", "", new Date(), "", user.getPhone(), "", user2);
                        this.poilceRepo.save(police);
                    } else {
                        Tenant tenant = new Tenant("", "", "", "", "", new Date(), user.getPhone(), null, 0.0, 0, 0, "", user2);
                        this.tenantRepo.save(tenant);
                    }


                    model.addAttribute("user", new User());
                    model.addAttribute("rolelist", this.roleRepo.findAll());
                    model.addAttribute("successMsg", "User save Successfully");
                }
            }
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
        model.addAttribute("rolelist", this.roleRepo.findAll());
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



}
