package com.dk.geek;

import com.dk.geek.config.ByAutowiredAnnotationBeanPostProcessorConfigure;
import com.dk.geek.repository.ByAutowiredAnnotationBeanPostProcessorRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 依赖注入，
 *
 * @author dkay
 * @version 1.0
 */
public class ByAutowiredAnnotationBeanPostProcessor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ByAutowiredAnnotationBeanPostProcessorConfigure.class,
                ByAutowiredAnnotationBeanPostProcessorRepo.class);
        context.refresh();

        ByAutowiredAnnotationBeanPostProcessorRepo bean = context.getBean(ByAutowiredAnnotationBeanPostProcessorRepo.class);
        System.out.println("bean = " + bean);
    }
}
