package com.dk.geek.repository;

import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dkay
 * @version 1.0
 */
@Slf4j
public class DependencyInjectionByManualAnnotationRepo {

    @Autowired
    private CommonUser commonUser;

    private Person person;

    public CommonUser getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUser commonUser) {
        log.debug("setCommonUser # injection by setter method");
        this.commonUser = commonUser;
    }

    public Person getPerson() {
        return person;
    }

    /**
     * dependency injection by method
     */
    @Autowired
    public void setPerson(Person person) {
        log.debug("setPerson # injection by method");
        this.person = person;
    }


    @Override
    public String toString() {
        return "DependencyInjectionByManualAnnotationRepo{" +
                "commonUser=" + commonUser +
                ", person=" + person +
                '}';
    }
}
