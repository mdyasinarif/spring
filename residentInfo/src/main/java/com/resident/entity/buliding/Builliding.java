package com.resident.entity.buliding;

import com.resident.entity.address.Thana;
import com.resident.entity.user.HouseOwner;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Builliding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "builling_owner",
            joinColumns = @JoinColumn(name = "builling_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<HouseOwner> houseOwner;

    public Builliding() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

