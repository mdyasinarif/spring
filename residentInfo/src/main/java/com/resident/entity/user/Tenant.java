package com.resident.entity.user;

import com.resident.entity.admin.User;

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

    private String photo;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Tenant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nidNo;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNoOfMamber() {
        return noOfMamber;
    }

    public void setNoOfMamber(int noOfMamber) {
        this.noOfMamber = noOfMamber;
    }

    public int getNoOfServent() {
        return noOfServent;
    }

    public void setNoOfServent(int noOfServent) {
        this.noOfServent = noOfServent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
