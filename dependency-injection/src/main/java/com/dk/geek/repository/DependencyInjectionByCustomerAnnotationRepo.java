package com.dk.geek.repository;

import com.dk.geek.annotation.CustomerAnnotationExpandAutowired;
import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;

/**
 * 自动注入，基于自定义注解实现
 *
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByCustomerAnnotationRepo {
    @CustomerAnnotationExpandAutowired
    private Person person;

    private CommonUser commonUser;

    public CommonUser getCommonUser() {
        return commonUser;
    }

    @CustomerAnnotationExpandAutowired
    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }

    @Override
    public String toString() {
        return "DependencyInjectionByCustomerAnnotationRepo{" +
                "person=" + person +
                ", commonUser=" + commonUser +
                '}';
    }
}
