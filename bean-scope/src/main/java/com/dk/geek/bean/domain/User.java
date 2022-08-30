package com.dk.geek.bean.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author dkay
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class User implements InitializingBean, DisposableBean, BeanNameAware {
    private String name;
    private Integer age;
    private Long timestamp;

    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    /* initialization */

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("%s 用户对象初始化... InitializingBean \n", beanName);
    }

    @PostConstruct
    public void initUser() {
        System.out.printf("%s 用户对象初始化... PostConstruct \n", beanName);
    }

    public void init() {
        System.out.printf("%s 用户对象初始化... init method \n", beanName);
    }

    /* destroy */

    @Override
    public void destroy() throws Exception {
        System.out.printf("%s 用户对象销毁中... DisposableBean \n", beanName);
    }

    @PreDestroy
    public void destroyUser() {
        System.out.printf("%s 用户对象销毁中... PreDestroy \n", beanName);
    }

    public void destroyMethod() {
        System.out.printf("%s 用户对象销毁中... init method \n", beanName);
    }
}
