package com.resident.entity.address;

import com.resident.entity.address.Division;
import com.resident.entity.user.Police;

import javax.persistence.*;

@Entity
public class Thana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String note;


    @ManyToOne
    @JoinColumn(name = "citycorporation_id")
    private CityCorporation cityCorporation;

    public Thana() {
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

    public CityCorporation getCityCorporation() {
        return cityCorporation;
    }

    public void setCityCorporation(CityCorporation cityCorporation) {
        this.cityCorporation = cityCorporation;
    }
}

