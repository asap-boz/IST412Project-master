package com.example.ist412project.service;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.model.OutstandingLoan;
import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.repository.LoanApplicationRepository;
import com.example.ist412project.repository.OutstandingLoanRepository;
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

    @Autowired
    private OutstandingLoanRepository outstandingLoanRepository;

    @Override
    public List<LoanApplicationModel> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @Override
    public void createLoanApplication(LoanApplicationModel loanApplication, Long userID) {
        loanApplicationRepository.save(loanApplication);

        OutstandingLoan outstandingLoan = new OutstandingLoan(loanApplication);
        outstandingLoanRepository.save(outstandingLoan);
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

    public Long getLoanIdFromUserId(Long userId) {
        List<LoanApplicationModel> list = getAllLoanApplications();

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getUserID() == userId)
                return list.get(i).getAid();
        }
        return (long) -1;
    }



    public LoanApplicationModel getLoanApplicationByUserId(Long userId) {
        // Implement logic to fetch a single loan application based on userId
        // For example, you might use findOne or findById
        return loanApplicationRepository.findById(userId).orElse(null);
    }

}
