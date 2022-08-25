package com.dk.geek.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * @author dkay
 */
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Autowired
public @interface CustomerAnnotationExpandAutowired {
}
