package com.example.ist412project.service;

import com.example.ist412project.model.OutstandingLoan;
import com.example.ist412project.model.Payment;

public interface OutstandingLoanService {

    void applyPayment(Payment payment, OutstandingLoan loan);

    OutstandingLoan getOutstandingLoanFromLoanId(Long id);
}
