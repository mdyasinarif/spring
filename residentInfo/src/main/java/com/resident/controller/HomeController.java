package com.resident.controller;


import com.resident.entity.admin.Role;
import com.resident.entity.admin.User;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Police;
import com.resident.entity.user.Tenant;
import com.resident.repo.adddressrepo.ThanaRepo;
import com.resident.repo.adminrepo.RoleRepo;
import com.resident.repo.adminrepo.UserRepo;
import com.resident.repo.userrepo.HouseOwnerRepo;
import com.resident.repo.userrepo.PoilceRepo;
import com.resident.repo.userrepo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;


@Controller
public class HomeController {







    @GetMapping(value = "/editable")
    public String displayeditabletable() {
        return "editable-table";
    }

    @GetMapping(value = "/addrow")
    public String addrow() {
        return "addrow";
    }


}
//insert into role(role_name) values ("POLICE");
//insert into role(role_name) values ("HOUSEOWNER");
//insert into role(role_name) values ("TENANT");