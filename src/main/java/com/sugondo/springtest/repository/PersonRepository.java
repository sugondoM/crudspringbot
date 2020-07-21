package com.sugondo.springtest.repository;

import com.sugondo.springtest.dao.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
