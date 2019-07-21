package com.resident.entity.user;

import com.resident.entity.address.Thana;
import com.resident.entity.admin.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String batchId;
    private String post;
    private String nid;
    private Date dateOfBirth;
    private String gender;
    private String contractNo;

    @OneToOne
    private User user;




}
