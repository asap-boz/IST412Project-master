package com.example.ist412project.service;

import com.example.ist412project.model.AutoLoan;
import com.example.ist412project.model.AutoLoan;

import java.util.List;

public interface ALoanServ {
    void saveLoan(AutoLoan autoLoan);

    public List<AutoLoan> accessByUser(Long userID);

    public void processPayment(Long id, Long amount);
}
