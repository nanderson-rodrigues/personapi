
package com.digitalinnovation.one.personapi.service;

import com.digitalinnovation.one.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.personapi.entity.Person;
import com.digitalinnovation.one.personapi.repository.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
            .message("Created Person with ID " + savedPerson.getId())
            .build();
    }
}