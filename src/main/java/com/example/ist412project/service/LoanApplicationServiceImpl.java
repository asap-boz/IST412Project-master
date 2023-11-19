package com.example.ist412project.service;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.repository.LoanApplicationRepository;
import com.example.ist412project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private UserRepository UserRepository;

    @Override
    public List<LoanApplicationModel> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @Override
    public void createLoanApplication(LoanApplicationModel loanApplication, Long userID) {
        loanApplicationRepository.save(loanApplication);
    }

    @Override
    public void createLoanApplicationForUser(LoanApplicationModel loanApplication, Long userId) {
        // Retrieve user information from the UserRepository based on the provided userId
        UserInfoModel user = UserRepository.getUserByUid(userId);
        // Set the user for the loan application
        loanApplication.setUser(user);
        // Save the loan application to the repository
        loanApplicationRepository.save(loanApplication);
    }

}
