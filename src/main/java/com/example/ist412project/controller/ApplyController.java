package com.example.ist412project.controller;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplyController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @GetMapping("/apply")
    public String showApplyPage(Model model, @RequestParam Long userID) {
        model.addAttribute("loanApplication", new LoanApplicationModel());
        model.addAttribute("userID", userID); // Add userID to the model
        return "apply";
    }

    @PostMapping("/apply")
    public String submitLoanApplication(@ModelAttribute("loanApplication") LoanApplicationModel loanApplication, Model model, @RequestParam Long userID) {
        // Save the loan application data to the database
        model.addAttribute("user", new UserInfoModel());
        loanApplicationService.createLoanApplication(loanApplication, userID);

        // Redirect to a success page or the dashboard
        return "loanApplicationSubmitted"; // Update with your actual dashboard URL
    }
}
