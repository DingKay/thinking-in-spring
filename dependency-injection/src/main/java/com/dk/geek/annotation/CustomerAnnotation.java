package com.dk.geek.annotation;

import java.lang.annotation.*;

/**
 * @author dkay
 */
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerAnnotation {
}
