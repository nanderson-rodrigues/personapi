package com.digitalinnovation.one.personapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.digitalinnovation.one.personapi.dto.request.PersonDTO;
import com.digitalinnovation.one.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.personapi.entity.Person;
import com.digitalinnovation.one.personapi.repository.PersonRepository;
import com.digitalinnovation.one.personapi.utils.PersonUtils;

import org.h2.command.ddl.CreateFunctionAlias;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
public class PersonSeviceTest {
    
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonIdThanReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();

        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson);
        MessageResponseDTO successMessage =  personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Person expectedSavedPerson) {
        return MessageResponseDTO.builder()
                        .message("Created Person with ID"+ expectedSavedPerson.getId())
                        .build();
    }
    
}
