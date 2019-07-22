package com.resident.entity.buliding;

import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "house_rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buillding_id")
    private Buillding buillding;

   @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "houseOwner_id")
    private HouseOwner houseOwner;

    @ManyToOne
    @JoinColumn(name = "tena_id")
    private Tenant tenant;


    private Double rentAmount;

    @Temporal(TemporalType.DATE)
    private Date rentdate;

    @Temporal(TemporalType.DATE)
    private Date currentdate;
    private String rentcondition;

}
