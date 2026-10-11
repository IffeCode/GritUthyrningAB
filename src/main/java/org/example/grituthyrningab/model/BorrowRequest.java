package org.example.grituthyrningab.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BorrowRequest {

    @NotNull(message = "Person Id is required!")
    private Long personId;

    @NotNull(message = "Tool Id is required!")
    private Long toolId;

    @NotNull(message = "due date is required!")
    @FutureOrPresent(message = "Due date must be today or in the future!")
    private LocalDate dueDate;

    public BorrowRequest() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
