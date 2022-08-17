package com.dk.geek.domain;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author dkay
 * @version 1.0
 */
public class InitializationBean implements InitializingBean {

    @PostConstruct
    public void initByAnnotation() {
        System.out.println("@PostConstruct initialization start");
    }

    public void initByInitMethod() {
        System.out.println("initialization method initialization start");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializationBean afterPropertiesSet initialization start");
    }
}
