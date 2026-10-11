package org.example.grituthyrningab.service;

import jakarta.transaction.Transactional;
import org.example.grituthyrningab.model.Loan;
import org.example.grituthyrningab.model.Person;
import org.example.grituthyrningab.model.Tool;
import org.example.grituthyrningab.repository.LoanRepository;
import org.example.grituthyrningab.repository.PersonRepository;
import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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

    public Loan borrowTool(Long personId, Long toolId, LocalDate dueDate){

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Person not found"
                ));

        Tool tool = toolRepository.findById(toolId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tool not found"
                ));

        if (dueDate == null || dueDate.isBefore(LocalDate.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Due date must be today or a future date!"
            );
        }

        boolean alreadyBorrowed = loanRepository.findAll().stream()
                .anyMatch(loan -> loan.getTool().getId().equals(toolId)
                && ("ACTIVE".equals(loan.getStatus())
                        || "OVERDUE".equals(loan.getStatus()))
                );

        if (alreadyBorrowed) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Tool already borrowed!");
        }

        Loan loan = new Loan();
        loan.setPerson(person);
        loan.setTool(tool);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setStatus("ACTIVE");

        person.getTools().add(tool);
        personRepository.save(person);

        return loanRepository.save(loan);
    }

    public Loan returnTool(Long loanId){
        Loan loan = get(loanId);
        if ("RETURNED".equals(loan.getStatus())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Tool has already been returned!");
        }

        loan.setStatus("RETURNED");
        loan.setReturnDate(LocalDate.now());

        Person person = loan.getPerson();
        Tool tool = loan.getTool();

        person.getTools().remove(tool);
        personRepository.save(person);

        return loanRepository.save(loan);
    }

    public void delete(Long id){
        loanRepository.delete(get(id));
    }

}
