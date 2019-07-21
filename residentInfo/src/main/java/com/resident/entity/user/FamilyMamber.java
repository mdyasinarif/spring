package com.resident.entity.user;

import com.resident.entity.address.Thana;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class FamilyMamber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String gender;
    private int age;
    private String nidNo;
    private String contractNo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private HouseOwner houseOwner;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = true)
    private Tenant tenant;

}
