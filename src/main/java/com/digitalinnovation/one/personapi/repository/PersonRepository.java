
package com.digitalinnovation.one.personapi.repository;

import com.digitalinnovation.one.personapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

    
}