package com.dk.geek.lookup;

import com.dk.geek.domain.Worker;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class HierarchicalLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HierarchicalLookupDemo.class);
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Worker.class);
        builder.addPropertyValue("age", 25)
                .addPropertyValue("name", "work-2")
                .addPropertyValue("position", "manage");
        parentContext.registerBeanDefinition("work", builder.getBeanDefinition());

        BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Worker.class);
        beanDefinition.addPropertyValue("age", 44)
                .addPropertyValue("name", "ceo")
                .addPropertyValue("position", "super boss");
        parentContext.registerBeanDefinition("ceo", beanDefinition.getBeanDefinition());
        parentContext.refresh();
        context.setParent(parentContext);
        context.refresh();

        Object ceo = context.getBean("ceo");
        System.out.println(ceo);

        context.close();
    }

    @Bean
    public String hello() {
        return "hello spring";
    }

    @Bean
    public Worker work() {
        Worker worker = Worker.builder().build();
        worker.setAge(21);
        worker.setName("work-3");
        worker.setPosition("leader");
        return worker;
    }
}
