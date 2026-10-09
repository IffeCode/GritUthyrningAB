package org.example.grituthyrningab.repository;

import org.example.grituthyrningab.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
