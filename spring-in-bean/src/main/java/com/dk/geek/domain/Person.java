package com.dk.geek.domain;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @author dkay
 * @version 1.0
 */
public class Person implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Person : destroy");
    }

    public void customizeDestroy() {
        System.out.println("Person : customizeDestroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Person : preDestroy");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Person : Garbage Collection");
    }

    private String name;
    private String address;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
