package org.example.grituthyrningab.service;

import org.example.grituthyrningab.model.Person;
import org.example.grituthyrningab.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person get(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Person not found with id: " + id
                        ));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        Person existingPerson = get(id);

        if (person.getFullName() != null) {
            existingPerson.setFullName(person.getFullName());
        }
        if (person.getEmail() != null) {
            existingPerson.setEmail(person.getEmail());
        }
        if (person.getPhoneNumber() != null) {
            existingPerson.setPhoneNumber(person.getPhoneNumber());
        }
        if (person.getUsername() != null) {
            existingPerson.setUsername(person.getUsername());
        }

        return personRepository.save(existingPerson);
    }

    //om person finns skickas json body annars får vi 404 "not found"
    public void delete(Long id) {
        personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Person not found with id: " + id
        ));

        personRepository.deleteById(id);

    }


}
