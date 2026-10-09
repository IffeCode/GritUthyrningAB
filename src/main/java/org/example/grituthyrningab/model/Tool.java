package org.example.grituthyrningab.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tools")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolDescription() {
        return toolDescription;
    }

    public void setToolDescription(String toolDescription) {
        this.toolDescription = toolDescription;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", toolDescription='" + toolDescription + '\'' +
                '}';
    }
}
