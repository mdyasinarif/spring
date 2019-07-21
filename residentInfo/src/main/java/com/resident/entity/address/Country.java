package com.resident.entity.address;

import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "houseOwner_id")
    private HouseOwner houseOwner;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

}

