package com.resident.entity.address;

import javax.persistence.*;

@Entity
public class CityCorporation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String holdingNo;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}

