
package com.digitalinnovation.one.personapi.utils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import com.digitalinnovation.one.personapi.dto.request.PersonDTO;
import com.digitalinnovation.one.personapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Nanderson";
    private static final String LAST_NAME = "Rodrigues";
    private static final String CPF_NUMBER = "222.112.411-90";
    private static final long PERSON_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(1998, 12, 20);
    
    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-02-2020")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
            .id(PERSON_ID)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_DATE)
            .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
            .build();
    }
}