package org.example.grituthyrningab.service;

import jakarta.transaction.Transactional;
import org.example.grituthyrningab.repository.LoanRepository;
import org.example.grituthyrningab.repository.PersonRepository;
import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoanService {

    private LoanRepository loanRepository;
    private PersonRepository personRepository;
    private ToolRepository toolRepository;

    public LoanService(LoanRepository loanRepository,
                       PersonRepository personRepository,
                       ToolRepository toolRepository) {
        this.loanRepository = loanRepository;
        this.personRepository = personRepository;
        this.toolRepository = toolRepository;
    }
}
