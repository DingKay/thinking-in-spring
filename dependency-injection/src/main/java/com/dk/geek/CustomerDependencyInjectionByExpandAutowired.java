package com.dk.geek;

import com.dk.geek.config.DependencyInjectionByCustomerAnnotationConfigure;
import com.dk.geek.repository.DependencyInjectionByCustomerAnnotationRepo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class CustomerDependencyInjectionByExpandAutowired {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DependencyInjectionByCustomerAnnotationConfigure.class,
                        DependencyInjectionByCustomerAnnotationRepo.class);

        ObjectProvider<DependencyInjectionByCustomerAnnotationRepo> provider = applicationContext.getBeanProvider(DependencyInjectionByCustomerAnnotationRepo.class);

        DependencyInjectionByCustomerAnnotationRepo object = provider.getObject();
        System.out.println("object = " + object);
    }
}
