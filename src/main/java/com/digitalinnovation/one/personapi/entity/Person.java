package com.digitalinnovation.one.personapi.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    
    private Long id;

    private String firstName;

    private String LastName;
    
    private String cpf;

    private LocalDate BirthDate;

    private List<Phone> phones;
}
