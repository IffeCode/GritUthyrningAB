package org.example.grituthyrningab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Loan date is required!")
    @Column(nullable = false)
    private LocalDate loanDate;

    @NotNull(message = "Due date is required!")
    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;

    @NotNull(message = "Status is required!")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", person=" + person +
                ", tool=" + tool +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
