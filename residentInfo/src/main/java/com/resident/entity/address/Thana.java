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
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "police_id")
    private Police police;

}

