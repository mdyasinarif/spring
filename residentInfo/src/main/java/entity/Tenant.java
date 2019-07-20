package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private String flatNo;
    private int noOfMamber;
    private String maidName;
    private String maidNID;

    public Tenant() {
    }


}
