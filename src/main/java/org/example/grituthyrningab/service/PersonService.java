package org.example.grituthyrningab.service;

import org.example.grituthyrningab.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonService {

    private PersonRepository peronsRepository;

    public PersonService(PersonRepository peronsRepository) {
        this.peronsRepository = peronsRepository;
    }



}
