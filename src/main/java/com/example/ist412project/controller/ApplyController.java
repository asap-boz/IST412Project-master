package com.example.ist412project.controller;

import com.example.ist412project.model.LoanApplicationModel;
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
    public String showApplyPage(Model model) {
        model.addAttribute("loanApplication", new LoanApplicationModel());
        return "apply";
    }

    @PostMapping("/apply")
    public String submitLoanApplication(@ModelAttribute("loanApplication") LoanApplicationModel loanApplication) {
        // Save the loan application data to the database
        loanApplicationService.createLoanApplication(loanApplication);

        // Redirect to a success page or the dashboard
        return "redirect:/Success"; // Update with your actual dashboard URL
    }
}
