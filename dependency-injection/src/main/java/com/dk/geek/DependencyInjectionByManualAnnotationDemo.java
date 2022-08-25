package com.dk.geek;

import com.dk.geek.config.DependencyInjectionByManualAnnotationConfigure;
import com.dk.geek.repository.DependencyInjectionByManualAnnotationRepo;
import org.springframework.beans.factory.ObjectProvider;
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

        ObjectProvider<DependencyInjectionByManualAnnotationRepo> beanProvider = context.getBeanProvider(DependencyInjectionByManualAnnotationRepo.class);
        DependencyInjectionByManualAnnotationRepo object = beanProvider.getObject();
        System.out.println("object = " + object);
    }
}
