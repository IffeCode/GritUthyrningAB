package org.example.grituthyrningab.controller;

import jakarta.validation.Valid;
import org.example.grituthyrningab.model.BorrowRequest;
import org.example.grituthyrningab.model.Loan;
import org.example.grituthyrningab.service.LoanService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/")
    public List<Loan> listAll(){
        return loanService.listAll();
    }

    @GetMapping("/{id}")
    public Loan get(@PathVariable Long id){
        return loanService.get(id);
    }

    @PostMapping("/borrow")
    @ResponseStatus(HttpStatus.CREATED)
    public Loan borrowTool(@Valid @RequestBody BorrowRequest request){

        return loanService.borrowTool(
                request.getPersonId(),
                request.getToolId(),
                request.getDueDate()
        );
    }

    @PutMapping("{id}/return")
    public Loan returnTool(@PathVariable Long id){
        return loanService.returnTool(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        loanService.delete(id);
    }


}
