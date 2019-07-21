package com.resident.controller;


import com.resident.repo.RoleRepo;
import com.resident.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "add")
    public String addRoleView(Role role){
        return "admin/role";

    }

    @PostMapping(value = "add")
    public String addRole(@Valid Role role, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/role";
        }else{
            if(role != null){
                Role role1=this.repo.findByRoleName(role.getRoleName());
                if(role1 != null ){
                    model.addAttribute("existMsg","RoleName is already exist");
                }else{
                    this.repo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "admin/role";
    }

    @GetMapping(value = "rolelist")
    public String roleList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "admin/rolelist";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model){
        model.addAttribute("role", this.repo.getOne(id));
        return "admin/roleedit";

    }

    @PostMapping(value = "edit/{id}")
    public String editRole(@Valid Role role, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "admin/roleedit";
        }else{
            if(role != null){
                Role role1=this.repo.findByRoleName(role.getRoleName());
                if(role1 != null ){
                    model.addAttribute("existMsg","RoleName is already exist");
                    return "admin/roleedit";
                }else{
                    this.repo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/role/rolelist";
    }

    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id){
        this.repo.deleteById(id);
        return "redirect:/role/rolelist";

    }
}
