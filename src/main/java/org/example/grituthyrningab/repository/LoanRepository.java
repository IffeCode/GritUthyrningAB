package org.example.grituthyrningab.repository;

import org.example.grituthyrningab.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
