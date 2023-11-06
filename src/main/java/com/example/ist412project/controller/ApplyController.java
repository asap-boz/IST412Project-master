package com.example.ist412project.controller;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ist412project.service.UserService;
import com.example.ist412project.model.UserInfo;

@Controller
public class ApplyController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @GetMapping("/apply")
    public String showApplyPage(Model model) {
        model.addAttribute("loanApplicationModel", new LoanApplicationModel());
        return "apply";
    }

    @PostMapping("/apply")
    public String submitLoanApplication(@ModelAttribute LoanApplicationModel loanApplicationModel) {
        // Save the loan application data to the database
        loanApplicationService.saveLoanApplication(loanApplicationModel);

        // Redirect to a success page or the dashboard
        return "redirect:/dashboard/user"; // Update with your actual dashboard URL
    }
}
