package com.springHibernet.springHibernet.Controller;

import com.springHibernet.springHibernet.entity.Department;
import com.springHibernet.springHibernet.entity.Student;
import com.springHibernet.springHibernet.repo.DepartmentRepo;
import com.springHibernet.springHibernet.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class StuentController {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping(value = "/student")
    public String displaySudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("deplist", this.departmentRepo.findAll());
        return "student";
    }

    @PostMapping(value = "/student")
    public String save(Model model, @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something Wrong");
        } else {
            this.repo.save(student);
            model.addAttribute("successMsg", "Data save Successfully");
            model.addAttribute("list", this.repo.findAll());
            model.addAttribute("deplist", this.departmentRepo.findAll());
        }
        return "student";
    }

    //    @GetMapping(value = "/studentByDep")
//    public String showStudentsByDepartyment(Model model){
//        Department department = new Department();
//        department.setId(1L);
//        model.addAttribute("listbydep",this.repo.findAllByDepartment(department));
//            return "studentByDepartment";
//    }
    @GetMapping(value = "/studentByDep")
    public String showStudentsByDepartyment(Model model, @RequestParam(value = "depid", required = false,
            defaultValue = "1") Long id) {
        model.addAttribute("deplist", this.departmentRepo.findAll());
        Department department = new Department();
        department.setId(id);

        model.addAttribute("lsitByDept", this.repo.findAllByDepartmentOrderByName(department));
        return "studentByDepartment";
    }

    @GetMapping(value = "/profile")
    public String showStudentsById(Model model, @RequestParam(value = "studentid", required = false,
            defaultValue = "1") Long id) {
        model.addAttribute("slist", this.repo.findAll());
        model.addAttribute("student", this.repo.getOne(id));
        return "profilePage";
    }

    @GetMapping(value = "/deptandGender")

    public String showDeptandGender(Model model, @RequestParam(value = "depid", required = false,
            defaultValue = "1") Long id, @RequestParam(value = "gender", required = false,
            defaultValue = "Male") String gender) {

        Department department = new Department();
        department.setId(id);

        model.addAttribute("lsitByDept", this.repo.findAllByDepartmentAndGender(department, gender));
        model.addAttribute("countDept", this.repo.countAllByDepartmentAndGender(department, gender));
        model.addAttribute("deplist", this.departmentRepo.findAll());
        return "deptandGender";
    }

    @GetMapping(value = "/studentByage")

    public String showDeptandGender(Model model, @RequestParam(value = "age", required = false,
            defaultValue = "20") int age) {

        model.addAttribute("slist", this.repo.findAllByAgeGreaterThanEqual(age));

        return "studentByage";
    }
}
