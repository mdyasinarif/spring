package com.resident.dto;

import com.resident.entity.address.Thana;
import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
import com.resident.entity.buliding.Rent;
import com.resident.entity.buliding.RentCollection;
import com.resident.entity.user.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UserDto {
    private String userName;
    private String phone;
    Iterable<Employee> employees;
    Iterable<FamilyMamber> familyMambers;
    Iterable<HouseOwner> houseOwners;
    Iterable<Police> police;
    Iterable<Tenant> tenants;
    Iterable<Building> buildings;
    Iterable<Flat> flats;
    Iterable<Rent> rents;
    Iterable<RentCollection> rentCollections;
    Iterable<Thana> thanas;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Iterable<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public Iterable<FamilyMamber> getFamilyMambers() {
        return familyMambers;
    }

    public void setFamilyMambers(Iterable<FamilyMamber> familyMambers) {
        this.familyMambers = familyMambers;
    }

    public Iterable<HouseOwner> getHouseOwners() {
        return houseOwners;
    }

    public void setHouseOwners(Iterable<HouseOwner> houseOwners) {
        this.houseOwners = houseOwners;
    }

    public Iterable<Police> getPolice() {
        return police;
    }

    public void setPolice(Iterable<Police> police) {
        this.police = police;
    }

    public Iterable<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Iterable<Tenant> tenants) {
        this.tenants = tenants;
    }

    public Iterable<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Iterable<Building> buildings) {
        this.buildings = buildings;
    }

    public Iterable<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Iterable<Flat> flats) {
        this.flats = flats;
    }

    public Iterable<Rent> getRents() {
        return rents;
    }

    public void setRents(Iterable<Rent> rents) {
        this.rents = rents;
    }

    public Iterable<RentCollection> getRentCollections() {
        return rentCollections;
    }

    public void setRentCollections(Iterable<RentCollection> rentCollections) {
        this.rentCollections = rentCollections;
    }

    public Iterable<Thana> getThanas() {
        return thanas;
    }

    public void setThanas(Iterable<Thana> thanas) {
        this.thanas = thanas;
    }
}
