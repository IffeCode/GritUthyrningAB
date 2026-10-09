package org.example.grituthyrningab.service;

import org.example.grituthyrningab.model.Person;
import org.example.grituthyrningab.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }


}
