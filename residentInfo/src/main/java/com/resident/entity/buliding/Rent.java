package com.resident.entity.buliding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long builldingId;
    private Long flatId;
    private Long houseOwnerId;
    private Double rent;
    private Date rentdate;
    private String condition;

}
