package com.resident.controller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.user.Employee;
import com.resident.entity.user.FamilyMamber;
import com.resident.repo.EmployeeRepo;
import com.resident.repo.HouseOwnerRepo;
import com.resident.repo.TenantRepo;
import com.resident.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private HouseOwnerRepo houseOwnerRepo;
    @Autowired
    private TenantRepo tenantRepo;


    @GetMapping(value = "add")
    public String addEmployeeView(Employee employee, Model model) {

        return "user/employee/add";

    }

    @PostMapping(value = "add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/employee/add";

        } else {
            if (employee != null) {
                Employee employee1 = this.repo.findByName(employee.getName());
                if (employee1 != null) {
                    model.addAttribute("existMsg", "EmployeeName is already exist");
                } else {
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    User user =this.userRepo.findByUserName(auth.getName());

                    String rolename=null;
                    for(Role r : user.getRoles()){
                        rolename =r.getRoleName();
                    }
                    if(rolename.equalsIgnoreCase("HOUSEOWNER")){
                        employee.setHouseOwner(this.houseOwnerRepo.findByUser(user));
                    }else  if(rolename.equalsIgnoreCase("TENANT")){
                        employee.setTenant(this.tenantRepo.findByUser(user));
                    }
                    this.repo.save(employee);
                    model.addAttribute("employee", new Employee());
                    model.addAttribute("successMsg", "Employee save Successfully");
                }
            }
        }
        return "user/employee/add";
    }

    @GetMapping(value = "list")
    public String employeeList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String rolename = null;
        for (Role r : this.userRepo.findByUserName(auth.getName()).getRoles()) {
            rolename = r.getRoleName();
        }
        Iterable<Employee> list = null;
        if (rolename.equalsIgnoreCase("HOUSEOWNER")) {
            list = this.repo.findAllByHouseOwner(this.houseOwnerRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        } else if (rolename.equalsIgnoreCase("TENANT")) {
            list = this.repo.findAllByTenant(this.tenantRepo.findByUser(this.userRepo.findByUserName(auth.getName())));
        }


        model.addAttribute("list", list);

        return "user/employee/list";
    }

    @GetMapping(value = "edit/{id}")
    public String editEmployeeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", this.repo.getOne(id));
        return "user/employee/edit";

    }

    @PostMapping(value = "edit/{id}")
    public String editEmployee(@Valid Employee employee, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/employee/edit";
        } else {
            if (employee != null) {
                Employee employee1 = this.repo.findByName(employee.getName());
                if (employee1 != null) {
                    model.addAttribute("existMsg", "EmployeeName is already exist");
                    return "user/employee/edit";
                } else {
                    this.repo.save(employee);
                    model.addAttribute("employee", new Employee());
                    model.addAttribute("successMsg", "EmployeeName save Success");
                }
            }
        }
        return "redirect:/user/employee/list";
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/user/employee/list";

    }
}
