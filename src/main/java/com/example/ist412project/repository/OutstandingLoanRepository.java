package com.example.ist412project.repository;

import com.example.ist412project.model.LoanApplicationModel;
import com.example.ist412project.model.OutstandingLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutstandingLoanRepository extends JpaRepository<OutstandingLoan, Long> {

}
