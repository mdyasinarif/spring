package com.resident.entity.buliding;

import com.resident.entity.address.Thana;
import com.resident.entity.user.HouseOwner;
import com.resident.entity.user.Tenant;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "house_rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String rentType;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building builliding;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;

   @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "houseOwner_id")
    private HouseOwner houseOwner;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;


    private Double rentAmount;

    private Double advanceAmount;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentdate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date currentdate = new Date();
    private String rentcondition;

    public Rent() {
    }

    public Thana getThana() {
        return thana;
    }

    public void setThana(Thana thana) {
        this.thana = thana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public Building getBuilding() {
        return builliding;
    }

    public void setBuilding(Building builliding) {
        this.builliding = builliding;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(Double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public Date getRentdate() {
        return rentdate;
    }

    public void setRentdate(Date rentdate) {
        this.rentdate = rentdate;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }

    public String getRentcondition() {
        return rentcondition;
    }

    public void setRentcondition(String rentcondition) {
        this.rentcondition = rentcondition;
    }

    public Building getBuilliding() {
        return builliding;
    }

    public void setBuilliding(Building builliding) {
        this.builliding = builliding;
    }
}
