package com.resident.entity.buliding;

import com.resident.entity.user.HouseOwner;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean status;
    private Double rentAmount;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentDate;
    private String photo;
    private String note;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<HouseOwner> getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(Set<HouseOwner> houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Objects.equals(id, flat.id) &&
                Objects.equals(name, flat.name) &&
                Objects.equals(status, flat.status) &&
                Objects.equals(rentAmount, flat.rentAmount) &&
                Objects.equals(rentDate, flat.rentDate) &&
                Objects.equals(photo, flat.photo) &&
                Objects.equals(note, flat.note) &&
                Objects.equals(building, flat.building) &&
                Objects.equals(houseOwner, flat.houseOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, rentAmount, rentDate, photo, note, building, houseOwner);
    }
}

