package com.dk.geek.config;

import com.dk.geek.annotation.CustomerAnnotation;
import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @author dkay
 * @version 1.0
 */
public class ByAutowiredAnnotationBeanPostProcessorConfigure {

//    @Bean(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
//        processor.setAutowiredAnnotationType(CustomerAnnotation.class);
//        return processor;
//    }

    @Bean(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setAutowiredAnnotationType(CustomerAnnotation.class);
        return processor;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("kkk");
        person.setAge(22);
        person.setLabel(new String[]{"ahhh", "xxxi"});
        return person;
    }

    @Bean
    public CommonUser commonUser() {
        CommonUser commonUser = new CommonUser();
        commonUser.setName("zzz");
        return commonUser;
    }
}
