package org.example.grituthyrningab.service;

import jakarta.transaction.Transactional;
import org.example.grituthyrningab.model.Loan;
import org.example.grituthyrningab.repository.LoanRepository;
import org.example.grituthyrningab.repository.PersonRepository;
import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    //listar alla lån
    public List<Loan> listAll() {
        return loanRepository.findAll();
    }

    //hitta lån baserat på id
    public Loan get(long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Loan not found"
                ));
    }

}
