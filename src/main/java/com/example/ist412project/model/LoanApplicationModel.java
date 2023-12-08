package com.example.ist412project.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "applicationInfo")
public class LoanApplicationModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apid")
    private Long aid;
    @Column(name = "loanAmount")
    private Double loanAmount;
    @Column(name = "term")
    private Integer term;
    @Column(name = "interestRate")
    private Double interestRate = 2.5;
    @Column(name = "loanType")
    private String loanType;
    @Column(name = "maritalStatus")
    private String maritalStatus;
    @Column(name = "income")
    private Double income;
    @Column(name = "expenses")
    private Double expenses;
    @Column(name = "userID")
    private long userID;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoModel user;

    public UserInfoModel getUser() {
        return user;
    }

    public void setUser(UserInfoModel user) {
        this.user = user;
    }
}
