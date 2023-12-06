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

    // Display the loan application form page
    @GetMapping("/apply")
    public String showApplyPage(Model model, @RequestParam Long userID) {
        // Create a new LoanApplicationModel and add it to the model
        model.addAttribute("loanApplication", new LoanApplicationModel());
        // Add the userID to the model for reference
        model.addAttribute("userID", userID);
        return "apply";
    }

    // Process the submitted loan application form
    @PostMapping("/apply")
    public String submitLoanApplication(@ModelAttribute("loanApplication") LoanApplicationModel loanApplication, Model model, @RequestParam Long userID) {
        // Save the loan application data to the database through the service
        model.addAttribute("user", new UserInfoModel()); // This line appears redundant and may not be necessary
        model.addAttribute("userID", userID);
        loanApplicationService.createLoanApplication(loanApplication, userID);

        // Redirect to a success page or the dashboard
        return "loanApplicationSubmitted"; // Update with your actual dashboard URL
    }
}
