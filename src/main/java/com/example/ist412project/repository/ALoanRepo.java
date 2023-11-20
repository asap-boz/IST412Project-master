
package com.example.ist412project.repository;

import com.example.ist412project.model.AutoLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ALoanRepo extends JpaRepository<AutoLoan,Long> {
    @Query("SELECT u FROM AutoLoan u WHERE u.user.uid = ?1")
    List<AutoLoan> findByUser(Long userID);

    @Transactional
    @Modifying
    @Query("UPDATE AutoLoan u SET u.loanAmount=u.loanAmount-?2 WHERE u.loanid=?1")
    public int processPayment(Long id, Long amount);
}
