
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
    private ALoanServ aLoanServ;

    @Autowired
    private UserServImpl userServ;

    @GetMapping("/makeaPayment")
    public String makePayment(Model model, @RequestParam("userID") Long userID){
        //model.addAttribute("type", type);
        model.addAttribute("userID", userID);
        //model.addAttribute("balance", balance);
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        //to-do Add current balance here to model to be displayed
        return "makeaPayment";
    }

    @PostMapping("/makeaPayment")
    public String makePayment(@PathVariable("userID") Long id, @ModelAttribute("payment") Payment payment, Model model){
        Long amount = payment.getAmount();
        //Logic for subtracting amount from balance
//        if (type.equals("auto")) {
//            aLoanServ.processPayment(id, amount);
//        }
        return "thank_you";
    }

    @GetMapping("/auto_loan")
    public String showAutoLoan(Model model){
        model.addAttribute("autoLoan", new AutoLoan());
        return "auto_loan_application";
    }

    @PostMapping("/auto_loan")
    public String showAutoLoan(@ModelAttribute("autoLoan") AutoLoan autoLoan, Model model){
        Authentication userAuthInfo = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails)userAuthInfo.getPrincipal()).getUsername();
        autoLoan.setUser(userServ.accessByEmail(email));
        aLoanServ.saveLoan(autoLoan);
        return "thank_you";
    }
}