package com.dk.geek.util;

import com.dk.geek.domain.Person;

/**
 * @author dkay
 * @version 1.0
 */
public class PersonUtil {
    /**
     * create person object
     *
     * @return user
     * @see Person
     */
    public static Person createPerson(String name, Integer age, String ... label) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setLabel(label);
        return person;
    }
}
