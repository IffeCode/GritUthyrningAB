package org.example.grituthyrningab.controller;

import org.example.grituthyrningab.model.Person;
import org.example.grituthyrningab.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("person/")
    public List<Person> list(){
        return personService.listAll();
    }

}
