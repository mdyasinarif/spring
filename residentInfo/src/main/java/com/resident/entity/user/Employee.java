package com.resident.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nidNo;
    private String type;
    private Date dateOfBirth;
    private String education;
    private String contractNo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private HouseOwner houseOwner;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = true)
    private Tenant tenant;


}
