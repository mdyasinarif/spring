package com.resident.controller.admincontroller;


import com.resident.entity.user.Employee;
import com.resident.repo.userrepo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("list", this.repo.findAll());

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
