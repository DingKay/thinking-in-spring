package com.dk.geek.bean.annotation;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * @author dkay
 * @version 1.0
 * @see org.springframework.context.annotation.Scope
 */
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Scope("threadScope")
public @interface ThreadScope {
}
