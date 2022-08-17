package com.dk.geek.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author dkay
 * @version 1.0
 */
@Slf4j
public class Person implements InitializingBean, DisposableBean {
    private String name;
    private Integer age;
    private String[] label;

    public Person(String name, Integer age, String[] label) {
        log.debug("Person # all arguments constructor called");
        this.name = name;
        this.age = age;
        this.label = label;
    }

    public Person() {
        log.debug("Person # no arguments constructor called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        log.debug("Person # setName called");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        log.debug("Person # setAge called");
        this.age = age;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        log.debug("Person # setLabel called");
        this.label = label;
    }

    @PostConstruct
    private void init() {
        log.debug("initializationPerson # postConstruct annotation # called");
    }

    private void initPerson() {
        log.debug("initializationPerson # init method # called");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("destroyPerson # called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("initialization # initializationBean # called");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", label=" + Arrays.toString(label) +
                '}';
    }
}
