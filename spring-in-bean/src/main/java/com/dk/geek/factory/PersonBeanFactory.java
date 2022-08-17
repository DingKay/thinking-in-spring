package com.dk.geek.factory;

import com.dk.geek.domain.Person;

/**
 * @author dkay
 * @version 1.0
 */
public interface PersonBeanFactory {
    /**
     * get on person instance
     * @return Person
     */
    Person getPerson();
}
