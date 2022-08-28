package com.dk.geek.repo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyRepo {
    private String hello;

    @Autowired
    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getHello() {
        return hello;
    }
}
