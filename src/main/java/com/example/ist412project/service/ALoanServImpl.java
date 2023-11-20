
package com.example.ist412project.service;

import com.example.ist412project.model.AutoLoan;
import com.example.ist412project.repository.ALoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ALoanServImpl implements ALoanServ {

    @Autowired
    private ALoanRepo aLoanRepo;

    @Override
    public void saveLoan(AutoLoan autoLoan) { this.aLoanRepo.save(autoLoan); }

    public List<AutoLoan> accessByUser(Long userID){
        return this.aLoanRepo.findByUser(userID);
    }

    @Override
    public void processPayment(Long id, Long amount) {
        this.aLoanRepo.processPayment(id, amount);
    }
}
