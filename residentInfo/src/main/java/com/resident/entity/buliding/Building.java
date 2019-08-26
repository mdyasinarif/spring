package com.resident.entity.buliding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.resident.entity.address.Thana;
import com.resident.entity.user.HouseOwner;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "building_owner",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<HouseOwner> houseOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "building")
    private Set<Flat> flats;

    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }

    public Building() {
    }

    public Building(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Thana getThana() {
        return thana;
    }

    public void setThana(Thana thana) {
        this.thana = thana;
    }

    public Set<HouseOwner> getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(Set<HouseOwner> houseOwner) {
        this.houseOwner = houseOwner;
    }
}

