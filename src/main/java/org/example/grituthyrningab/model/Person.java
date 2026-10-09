package org.example.grituthyrningab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    /*
    @GeneratedValue - AUTO - fungerar som AUTOINCREMENT, användare skapas och id ges automatiskt
    @Column - unique - true, får bara finnas ett. Kan inte skapa nytt konto med redan använd mejl exempel
    @Pattern - kan användas för skapa regex
    @Size - hur många min eller/och max tecken som ska finnas
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    @Column(name = "name")
    @Size(min = 2, message = "Name must be at least 2 characters long!")
    private String fullName = "";

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email cannot be blank!")
    private String email = "";

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Please enter your phone number!")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$",
    message = "You have to enter the phone in international format (E.164)")
    private String phoneNumber = "";

    @Column(unique = true, nullable = false)
    @NotEmpty
    @Size(min = 4, message = "Username must contain at least 4 characters!")
    private String username = "";

    @Column(nullable = false) //får inte vara tom!
    //regex kontrollerar så att lösenordskravet följs
    //behöver också hasha lösenord - Använd BCrypt
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number and one special character!")
    private String password = "";

    @Column(nullable = false)
    private String role = "USER"; //Blir automatiskt user när användare skapas

    @ManyToMany
    @JoinTable(name = "person_tools",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "tools_id"))

    private List<Tool> tools = new HashSet<>();


    public Person() {
    }

    public Person(Long id, String fullName, String email, String phoneNumber,
                  String username, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
