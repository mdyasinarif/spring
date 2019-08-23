package com.resident.entity.buliding;

import com.resident.entity.user.HouseOwner;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean status;
    private String photo;
    private String flatsize;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFlatsize() {
        return flatsize;
    }

    public void setFlatsize(String flatsize) {
        this.flatsize = flatsize;
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

