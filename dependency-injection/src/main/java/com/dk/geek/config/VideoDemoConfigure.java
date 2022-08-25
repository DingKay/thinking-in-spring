package com.dk.geek.config;

import com.dk.geek.annotation.CustomerAnnotation;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class VideoDemoConfigure {
    @Bean
    public AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        postProcessor.setAutowiredAnnotationType(CustomerAnnotation.class);
        return postProcessor;
    }
}
