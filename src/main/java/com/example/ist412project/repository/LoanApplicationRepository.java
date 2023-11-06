package com.example.ist412project.repository;

import com.example.ist412project.model.LoanApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplicationModel, Long> {


    List<LoanApplicationModel> findAll();
}
