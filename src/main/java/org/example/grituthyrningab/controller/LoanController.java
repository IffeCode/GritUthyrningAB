package org.example.grituthyrningab.controller;

import org.example.grituthyrningab.model.Loan;
import org.example.grituthyrningab.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
