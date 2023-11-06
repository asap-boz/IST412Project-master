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
}
