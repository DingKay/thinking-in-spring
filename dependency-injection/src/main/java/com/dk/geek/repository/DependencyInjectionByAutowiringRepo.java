package com.dk.geek.repository;

import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByAutowiringRepo {
    private CommonUser commonUser;
    private Person person;

    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CommonUser getCommonUser() {
        return commonUser;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "DependencyInjectionByAutowiringRepo{" +
                "commonUser=" + commonUser +
                ", person=" + person +
                '}';
    }
}
