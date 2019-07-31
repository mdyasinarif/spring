package com.resident.controller.admincontroller;


import com.resident.entity.admin.User;
import com.resident.repo.adminrepo.RoleRepo;
import com.resident.repo.adminrepo.UserRepo;
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


    @PostMapping(value = "add")
    public String addRole(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/role";
        }else{
            if(user != null){
                User user1=this.repo.findByUserName(user.getUserName());
                if(user1 != null ){
                    model.addAttribute("existMsg","Userame is already exist");
                }else{
                    this.repo.save(user);
                    model.addAttribute("user",new User());
                    model.addAttribute("successMsg","User save Successfully");
                }           }
        }
        return "sing-up";
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
