package com.example.ist412project.service;

import com.example.ist412project.model.OutstandingLoan;
import com.example.ist412project.model.Payment;
import com.example.ist412project.repository.OutstandingLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutstandingLoanServiceImpl implements OutstandingLoanService{
    @Autowired
    OutstandingLoanRepository loanRepo;

    @Override
    public void applyPayment(Payment payment, OutstandingLoan loan) {

        Double diff = loan.getBalance() - payment.getAmount();
        if (diff <= 0) {
            diff = (double) 0;
            loan.setPaidOff(true);
        }

        loan.setBalance(diff);

        loanRepo.save(loan);
    }

    @Override
    public OutstandingLoan getOutstandingLoanFromLoanId(Long id) {
        List<OutstandingLoan> list = loanRepo.findAll();

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getId() == id && !list.get(i).getPaidOff())
                return list.get(i);
        }

        return null;
    }


}
