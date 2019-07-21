package com.resident.entity.buliding;

import com.resident.entity.user.HouseOwner;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Buillding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String houseNo;

    private String flatName;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "builling_owner",
            joinColumns = @JoinColumn(name = "builling_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<HouseOwner> houseOwner;

}

