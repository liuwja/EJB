package com.liuwjg.service.impl;

import com.liuwjg.bean.Person;
import com.liuwjg.service.PersonService;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Stateless
@Remote
public class PersonServiceImpl implements PersonService {

    //注入mysql的实体管理器
    @PersistenceContext(unitName = "mysql")
    private EntityManager em;
    @Override
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public void update(Person person) {
        em.merge(person);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.getReference(Person.class,id));
    }

    @Override
    public Person getPerson(Integer id) {
        return em.find(Person.class,id);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> personList = em.createQuery("select o from Person o where 1=1").getResultList();
        return personList;
    }
}
