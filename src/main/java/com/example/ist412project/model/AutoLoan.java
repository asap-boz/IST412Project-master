
package com.example.ist412project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="personalLoan")
public class AutoLoan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoModel user;
    @Column(name="full_name")
    private String fullName;
    @Column(name="address_line_1")
    private String addressLine1;
    @Column(name="address_line_2")
    private String addressLine2;
    @Column(name="country")
    private String country;
    @Column(name="state")
    private String state;
    @Column(name="zip_code")
    private String zipCode;
    @Column(name="phone_number")
    private long phoneNumber;
    @Column(name="income")
    private long income;
    @Column(name="loan_length_in_months")
    private long loanLengthInMonths;
    @Column(name="loan_amount")
    private long loanAmount;
    @Column(name="social_security")
    private long socialSecurity;
    @Column(name="car_make")
    private String carMake;
    @Column(name="car_model")
    private String carModel;
    @Column(name="car_year")
    private String carYear;
    @Column(name="trade_in_info")
    private String tradeInInfo;

    public long getLoanid() {
        return loanid;
    }

    public void setLoanid(long loanid) {
        this.loanid = loanid;
    }

    public UserInfoModel getUserInfo() {
        return user;
    }

    public void setUser(UserInfoModel user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getLoanLengthInMonths() {
        return loanLengthInMonths;
    }

    public void setLoanLengthInMonths(long loanLengthInMonths) {
        this.loanLengthInMonths = loanLengthInMonths;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public long getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(long socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getTradeInInfo() {
        return tradeInInfo;
    }

    public void setTradeInInfo(String tradeInInfo) {
        this.tradeInInfo = tradeInInfo;
    }
}
