package com.dk.geek.process;

import com.dk.geek.domain.InitializationBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanProcess implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof InitializationBean) {
            System.out.println("BeanPostProcessor postProcessAfterInitialization");
        }
        return bean;
    }
}
