package com.example.ist412project.service;

import com.example.ist412project.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.repository.LoanApplicationRepository;

import java.util.List;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationServiceImpl(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @Override
    public void saveLoanApplication(LoanApplicationModel loanApplicationModel) {
        loanApplicationRepository.save(loanApplicationModel);
    }

    @Override
    public List<LoanApplicationModel> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @Override
    public void createLoanApplication(LoanApplicationModel loanApplication) {
        loanApplicationRepository.save(loanApplication);
    }


    // You can add more methods for specific operations related to loan applications if needed.
}
