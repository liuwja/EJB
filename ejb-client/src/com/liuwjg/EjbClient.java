package com.liuwjg;

import com.liuwjg.bean.Person;
import com.liuwjg.service.PersonService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbClient {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
        pro.setProperty("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
        pro.setProperty("java.naming.provider.url","127.0.0.1");

        try {
            InitialContext ctx = new InitialContext(pro);
            System.out.println(ctx.getClass().getName());
            PersonService personService = (PersonService) ctx.lookup("PersonServiceImpl/remote");
            Person person = new Person();
            person.setName("刘伟杰");
            personService.save(person);
            System.out.println(person.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
