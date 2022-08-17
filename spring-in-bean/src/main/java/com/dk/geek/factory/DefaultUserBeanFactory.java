package com.dk.geek.factory;

import com.dk.geek.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author dkay
 * @version 1.0
 */
public class DefaultUserBeanFactory implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
