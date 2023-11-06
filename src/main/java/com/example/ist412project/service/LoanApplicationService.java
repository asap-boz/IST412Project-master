package com.example.ist412project.service;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanApplicationService {
    void saveLoanApplication(LoanApplicationModel loanApplicationModel);
    List<LoanApplicationModel> getAllLoanApplications();
}
