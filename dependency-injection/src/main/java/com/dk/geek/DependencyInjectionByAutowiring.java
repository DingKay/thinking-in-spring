package com.dk.geek;

import com.dk.geek.repository.DependencyInjectionByAutowiringRepo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByAutowiring {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        String configPath = "classpath:/META-INF/dependency-injection-autowiring.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(configPath);
        context.refresh();

        ObjectProvider<DependencyInjectionByAutowiringRepo> provider = context.getBeanProvider(DependencyInjectionByAutowiringRepo.class);
        provider.forEach(System.out::println);

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
    }
}
