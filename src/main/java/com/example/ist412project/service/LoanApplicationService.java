package com.example.ist412project.service;

import com.example.ist412project.model.LoanApplicationModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanApplicationService {
    List<LoanApplicationModel> getAllLoanApplications();
    void createLoanApplication(LoanApplicationModel loanApplication, Long userID);

    void createLoanApplicationForUser(LoanApplicationModel loanApplication, Long userId);

    Long getLoanIdFromUserId(Long userId);
    LoanApplicationModel getLoanApplicationByUserId(Long userId);
}
