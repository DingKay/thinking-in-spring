package com.geek.dk;

import com.geek.dk.domain.Person;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

/**
 * @author dkay
 * @version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
            System.out.println("beanInfo = " + beanInfo);
            System.out.println("beanInfo.getBeanDescriptor = " + beanInfo.getBeanDescriptor());
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }
}
