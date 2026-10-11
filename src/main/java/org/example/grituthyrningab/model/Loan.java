package org.example.grituthyrningab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tool_id", nullable = false)
    private Tool tool;

    @Column(nullable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;

    @Column(nullable = false)
    @Pattern(
            regexp = "^(ACTIVE|RETURNED|OVERDUE)$",
            message = "Status must be ACTIVE, RETURNED or OVERDUE!"
    )
    private String status = "ACTIVE";

    public Loan() {
    }

    public Loan(Long id, Person person, Tool tool,
                LocalDate loanDate, LocalDate dueDate,
                LocalDate returnDate, String status) {
        this.id = id;
        this.person = person;
        this.tool = tool;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}
