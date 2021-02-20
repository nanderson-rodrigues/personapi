
package com.digitalinnovation.one.personapi.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.digitalinnovation.one.personapi.dto.request.PersonDTO;
import com.digitalinnovation.one.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.personapi.entity.Person;
import com.digitalinnovation.one.personapi.exceptions.PersonNotFoundException;
import com.digitalinnovation.one.personapi.mapper.PersonMapper;
import com.digitalinnovation.one.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;    

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponse(savedPerson.getId(), "Create person with id ");
    }

	public List<PersonDTO> listAll() {
        
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
        
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }
    
    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        
        return createMessageResponse(updatedPerson.getId(), "Update person with id ");
	}

	public void delete(Long id) throws PersonNotFoundException {
        
        verifyIfExists(id);
        personRepository.deleteById(id);
    }
    
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        
        return personRepository.findById(id)
                                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        
        return MessageResponseDTO.builder()
                                .message(s + id)
                                .build();
    }

}