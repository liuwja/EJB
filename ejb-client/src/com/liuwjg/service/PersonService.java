package com.liuwjg.service;

import com.liuwjg.bean.Person;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonService {
    void save(Person person);
    void update(Person person);
    void delete(Integer id);
    Person getPerson(Integer id);
    List<Person> getPersons();
}
