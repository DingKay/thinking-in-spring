package com.dk.geek;

import com.dk.geek.repo.DependencyRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class ResolvableDependencyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(postProcessor -> postProcessor.registerResolvableDependency(String.class, "Hello,world."));
        context.register(DependencyRepo.class);
        context.refresh();

        DependencyRepo bean = context.getBean(DependencyRepo.class);
        System.out.println("bean.getHello() = " + bean.getHello());
    }
}
