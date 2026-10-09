package org.example.grituthyrningab.controller;

import jakarta.validation.Valid;
import org.example.grituthyrningab.model.Person;
import org.example.grituthyrningab.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //Listar alla person
    @GetMapping("person/")
    public List<Person> list(){
        return personService.listAll();
    }

    //Hämtar en specifik person med id
    @GetMapping("person/{id}")
    public Person get(@PathVariable Long id){
        return personService.get(id);
    }

    @PostMapping("person/")
    public Person create(@Valid @RequestBody Person person){
        return personService.save(person);
    }

    //update person med id
    @PutMapping("person/{id}")
    public ResponseEntity<?> update(@Valid
                         @RequestBody Person person,
                         @PathVariable Long id){
     return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete person - med id
    @DeleteMapping("person/{id}")
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }

}
