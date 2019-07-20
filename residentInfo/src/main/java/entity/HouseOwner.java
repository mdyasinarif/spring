package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseOwnerName;
    private String education;
    private String gender;
    private String nidNo;
    private String tinNo;
    private String contractNo;
    private Date dateOfBirth;
    private String houseNo;
    private String roadNo;
    private String area;
    private String policeStation;
    private String postOffice;
    private String cityCorp;
    private String municipality;
    private String upazila;
    private String word;
    private String district;
    private String country;
    private String houseType;
    private String noOfFlat;
    private String caretakerName;
    private String caretakerNID;
    private String income;
    private int noOfMamber;


}
