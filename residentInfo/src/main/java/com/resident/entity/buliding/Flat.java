package com.resident.entity.buliding;

import com.resident.entity.address.Division;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String note;

    @ManyToOne
    @JoinColumn(name = "buillding_id")
    private Buillding buillding;

    @ManyToMany
    @JoinTable(
            name = "flat_owner",
            joinColumns = @JoinColumn(name = "flat_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<HouseOwner> houseOwner;



}

