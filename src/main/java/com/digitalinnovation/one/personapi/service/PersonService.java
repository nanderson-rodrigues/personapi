
package com.digitalinnovation.one.personapi.service;

import com.digitalinnovation.one.personapi.dto.request.PersonDTO;
import com.digitalinnovation.one.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.personapi.entity.Person;
import com.digitalinnovation.one.personapi.mapper.PersonMapper;
import com.digitalinnovation.one.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;    

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
            .message("Created Person with ID " + savedPerson.getId())
            .build();
    }
}