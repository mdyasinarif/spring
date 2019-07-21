package com.resident.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PoliceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stationName;
    private String policeName;
    private String batchId;
    private String post;
    private String nid;
    private Date dateOfBirth;
    private String gender;
    private String contractNo;


}
