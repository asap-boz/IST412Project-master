package com.example.ist412project.repository;

import com.example.ist412project.model.OutstandingLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutstandingLoanRepository extends JpaRepository<OutstandingLoan, Long> {

}
