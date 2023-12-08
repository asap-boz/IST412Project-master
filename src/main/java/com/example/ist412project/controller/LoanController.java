
package com.example.ist412project.controller;

import com.example.ist412project.model.*;
import com.example.ist412project.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class LoanController {




    @Autowired
    private UserServImpl userServ;

    @Autowired
    private LoanApplicationServiceImpl loanServ;

    @Autowired
    private OutstandingLoanServiceImpl outstandingLoanService;

    @GetMapping("/makeaPayment")
    public String makePayment(Model model, @RequestParam("userID") Long userID){
        //model.addAttribute("type", type);
        model.addAttribute("userID", userID);
        //model.addAttribute("balance", balance);
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        OutstandingLoan loan = outstandingLoanService.getOutstandingLoanFromLoanId(loanServ.getLoanIdFromUserId(userID));
        if (loan == null)
            return "noLoans";
        model.addAttribute("loan", outstandingLoanService);
        //to-do Add current balance here to model to be displayed
        return "makeaPayment";
    }

    @PostMapping("/makeaPayment")
    public String makePayment(@RequestParam("userID") Long id, @ModelAttribute("payment") Payment payment, @ModelAttribute("loan") OutstandingLoan loan, Model model, @RequestParam Long userID){
        OutstandingLoan paidLoan = outstandingLoanService.getOutstandingLoanFromLoanId(loanServ.getLoanIdFromUserId(id));
        outstandingLoanService.applyPayment(payment, paidLoan,userID);

        model.addAttribute("userID", id);
        model.addAttribute("balance", paidLoan.getBalance());

        return "paymentSubmitted";
    }
}