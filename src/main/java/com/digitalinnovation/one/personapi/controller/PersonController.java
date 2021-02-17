package com.digitalinnovation.one.personapi.controller;

import javax.validation.Valid;

import com.digitalinnovation.one.personapi.dto.request.PersonDTO;
import com.digitalinnovation.one.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.personapi.entity.Person;
import com.digitalinnovation.one.personapi.repository.PersonRepository;
import com.digitalinnovation.one.personapi.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }
    

}
