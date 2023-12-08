package com.example.ist412project.controller;

import com.example.ist412project.model.OutstandingLoan;
import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.repository.OutstandingLoanRepository;
import com.example.ist412project.service.LoanApplicationService;
import com.example.ist412project.service.OutstandingLoanService;
import com.example.ist412project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewLoanController {
    @Autowired
    private LoanApplicationService loanApplicationService;
    @Autowired
    private OutstandingLoanRepository outstandingLoanRepository;
    @Autowired
    private OutstandingLoanService outstandingLoanService;

    private LoanApplicationModel loanApplicationModel;

private OutstandingLoan outstandingLoan;
    @GetMapping("/viewLoan")
    public String viewLoanPage(Model model, @RequestParam Long userID) {
        // Add userId to the model
        model.addAttribute("userID", userID);
        // Retrieve loan applications by user ID

        LoanApplicationModel loanApplication = loanApplicationService.getLoanApplicationByUserId(userID);

        // Add loan applications to the model
        model.addAttribute("loanApplications", loanApplication);

        outstandingLoan = outstandingLoanService.getOutstandingLoanFromLoanId(loanApplicationService.getLoanIdFromUserId(userID));

        if (loanApplication == null)
            return "noLoans";
        model.addAttribute("tax", loanApplication);
        model.addAttribute("outstandingLoan", outstandingLoan);

        model.addAttribute("paidOffAmount", loanApplication.getLoanAmount() - outstandingLoan.getBalance());

        // Return the view name
        return "viewLoan";
    }
}
