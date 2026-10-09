package org.example.grituthyrningab.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
public class Tool {

        /*
    @GeneratedValue - AUTO - fungerar som AUTOINCREMENT, användare skapas och id ges automatiskt
    @Column - unique - true, får bara finnas ett. Kan inte skapa nytt konto med redan använd mejl exempel
    @Pattern - kan användas för skapa regex
    @Size - hur många min eller/och max tecken som ska finnas
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    @Column(nullable = false)
    private String toolName;

    @Column(nullable = false)
    @Size(min = 15,
    message = "Description must contain at least 15 characters!")
    private String toolDescription;

    public Tool() {
    }

    public Tool(Long id, String toolName, String toolDescription) {
        this.id = id;
        this.toolName = toolName;
        this.toolDescription = toolDescription;
    }



}
