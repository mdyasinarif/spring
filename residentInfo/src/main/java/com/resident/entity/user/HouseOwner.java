package com.resident.entity.user;

import com.resident.entity.address.CityCorporation;
import com.resident.entity.address.Country;
import com.resident.entity.address.District;
import com.resident.entity.address.Division;
import com.resident.entity.buliding.Buillding;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // personal information section
    private String name;
    private String education;
    private String nidNo;
    private String gender;
    private String tinNo;
    private Date dateOfBirth;

    private String contractNo;

    private String income;
    // End personal information section



   // suporting member session
    private int noOfMamber;


    private int noOfEmploye;

    // End suporting member session



}
