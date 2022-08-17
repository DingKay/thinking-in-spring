package com.dk.geek.factory;

import com.dk.geek.domain.Person;

/**
 * @author dkay
 * @version 1.0
 */
public class DefaultPersonBeanFactory implements PersonBeanFactory {

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setName("ahhaha");
        person.setAge(44);
        person.setAddress("xzc");
        return person;
    }
}
