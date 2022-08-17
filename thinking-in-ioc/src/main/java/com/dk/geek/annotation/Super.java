package com.dk.geek.annotation;

import java.lang.annotation.*;

/**
 * @author dkay
 * @version 1.0
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
