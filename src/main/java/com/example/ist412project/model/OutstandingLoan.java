package com.example.ist412project.model;

import com.example.ist412project.service.OutstandingLoanServiceImpl;
import jakarta.persistence.*;

@Entity
@Table(name = "outstandingLoan")
public class OutstandingLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "paid_off")
    private Boolean paidOff;
    @Column(name = "userID")
    private long userID;
    @OneToOne
    @JoinColumn(name = "apid")
    private LoanApplicationModel loan;


    public OutstandingLoan() {
        paidOff = true;
        balance = (double) 0;
        loan = null;
    }
    public OutstandingLoan(LoanApplicationModel app)
    {
        this.balance = app.getLoanAmount();
        this.loan = app;
        paidOff = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getPaidOff() {
        return paidOff;
    }

    public void setPaidOff(Boolean paidOff) {
        this.paidOff = paidOff;
    }

    public LoanApplicationModel getLoan() {
        return loan;
    }

    public void setLoan(LoanApplicationModel loan) {
        this.loan = loan;
    }
    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
