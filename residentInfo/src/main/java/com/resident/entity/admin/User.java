package com.resident.entity.admin;



import com.resident.entity.address.District;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String userName;



    @NotNull(message = "Enter Phone Number")
    @Column(unique = true)
    private String phone;

    @NotNull(message = "Enter A Password ")
    @Column(name = "password")
    private String password;



    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(User user) {
        this.userName = user.userName;
        this.phone = user.phone;
        this.password = user.password;
        this.roles = user.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPhone(), user.getPhone())&&
                Objects.equals(getPassword(), user.getPassword());
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
