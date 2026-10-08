package org.example.grituthyrningab.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;

    @Column(name = "name")
    @Size(min = 2, message = "Name must be atleast 2 characters long!")
    private String fullName = "";








}
