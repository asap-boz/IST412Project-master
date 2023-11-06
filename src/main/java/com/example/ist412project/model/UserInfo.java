package com.example.ist412project.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private long uid;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    public UserInfo() {

    }

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public UserInfo(long uid) {this.uid = uid;}
    public long getUid() {return uid;}
    public void setUid(long uid) {this.uid = uid;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public long getUserID() {
        return uid;
    }
}
