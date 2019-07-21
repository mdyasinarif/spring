package com.resident.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenantName;
    private String nidNo;
    private String tinNo;
    private String contractNo;
    private Date dateOfBirth;
    // address session



    // End address session

    // suporting member session
    private int noOfMamber;


    private int noOfServent;


    // End suporting member session


}
