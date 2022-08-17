package com.dk.geek;

import com.dk.geek.config.DependencyInjectionByManualAnnotationConfigure;
import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import com.dk.geek.repository.DependencyInjectionByManualAnnotationRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByManualAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DependencyInjectionByManualAnnotationConfigure.class,
                        DependencyInjectionByManualAnnotationRepo.class);
        context.getBeanProvider(Person.class).stream().forEach(System.out::println);
        context.getBeanProvider(CommonUser.class).stream().forEach(System.out::println);
    }
}
