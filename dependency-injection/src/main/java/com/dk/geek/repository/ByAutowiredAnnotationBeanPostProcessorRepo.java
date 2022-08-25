package com.dk.geek.repository;

import com.dk.geek.annotation.CustomerAnnotation;
import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dkay
 * @version 1.0
 */
public class ByAutowiredAnnotationBeanPostProcessorRepo {
    @CustomerAnnotation
    private Person person;

    @Autowired
    private Person autoPerson;

    private CommonUser commonUser;

    public CommonUser getCommonUser() {
        return commonUser;
    }

    @CustomerAnnotation
    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }

    @Override
    public String toString() {
        return "ByAutowiredAnnotationBeanPostProcessorRepo{" +
                "person=" + person +
                ", autoPerson=" + autoPerson +
                ", commonUser=" + commonUser +
                '}';
    }
}
