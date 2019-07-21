package com.resident.entity.address;

import javax.persistence.*;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String note;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

