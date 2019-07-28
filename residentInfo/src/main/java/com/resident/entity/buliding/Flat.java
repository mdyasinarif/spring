package com.resident.entity.buliding;

import com.resident.entity.user.HouseOwner;

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
    private Builliding builliding;

    @ManyToMany
    @JoinTable(
            name = "flat_owner",
            joinColumns = @JoinColumn(name = "flat_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<HouseOwner> houseOwner;

    public Flat() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Builliding getBuilliding() {
        return builliding;
    }

    public void setBuilliding(Builliding builliding) {
        this.builliding = builliding;
    }

    public Set<HouseOwner> getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(Set<HouseOwner> houseOwner) {
        this.houseOwner = houseOwner;
    }
}

