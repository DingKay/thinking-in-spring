package com.dk.geek.bean;

import com.dk.geek.domain.InitializationBean;
import com.dk.geek.process.BeanProcess;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanProcess.class);
        context.register(BeanInitializationDemo.class);

        context.refresh();
        context.close();
    }

    @Bean(initMethod = "initByInitMethod")
    public InitializationBean getBean() {
        return new InitializationBean();
    }
}
