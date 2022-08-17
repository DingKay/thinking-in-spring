package com.dk.geek.bean;

import com.dk.geek.domain.Person;
import com.dk.geek.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author dkay
 * @version 1.0
 */
@Import(AnnotationBeanDefinitionDemo.MyselfConfig.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Person.class);
        context.register(AnnotationBeanDefinitionDemo.class);

        registryUserBeanDefinition(context, "d-kay");
        registryUserBeanDefinition(context);
        context.refresh();

        Object person = context.getBean("person");
        System.out.println("person = " + person);

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println("beansOfType = " + beansOfType);

        Person onePerson = context.getBean("onePerson", Person.class);
        System.out.println("onePerson = " + onePerson);

        Map<String, User> userMap = context.getBeansOfType(User.class);
        System.out.println("userMap = " + userMap);
    }

    private static void registryUserBeanDefinition(AnnotationConfigApplicationContext context) {
        registryUserBeanDefinition(context, null);
    }

    private static void registryUserBeanDefinition(BeanDefinitionRegistry registry, String name) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("name", "dzzz")
                .addPropertyValue("age", 44);

        if (StringUtils.hasText(name)) {
            registry.registerBeanDefinition(name, builder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }


    public static class MyselfConfig {

        @Bean(name = "onePerson")
        public Person onePerson() {
            Person person = new Person();
            person.setAddress("nanjing");
            person.setAge(33);
            person.setName("kay");
            return person;
        }
    }
}
