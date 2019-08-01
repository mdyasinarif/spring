package com.resident.entity.user;

import com.resident.entity.address.Thana;
import com.resident.entity.admin.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;
    private String batchId;
    private String post;
    private String nid;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String contractNo;
    private String photo;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Police() {
    }

    public Police(String name, Thana thana, String batchId, String post, String nid, Date dateOfBirth, String gender, String contractNo, String photo, User user) {
        this.name = name;
        this.thana = thana;
        this.batchId = batchId;
        this.post = post;
        this.nid = nid;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contractNo = contractNo;
        this.photo = photo;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public Thana getThana() {
        return thana;
    }

    public void setThana(Thana thana) {
        this.thana = thana;
    }
}
