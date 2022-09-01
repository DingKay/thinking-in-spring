package com.dk.geek.bean.annotation;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author dkay
 * @version 1.0
 */
public class MyThreadLocal implements Scope {
    public static final String THREAD_SCOPE_NAME = "threadScope";
    private final ThreadLocal<Map<String, Object>> mapThreadLocal = ThreadLocal.withInitial(() -> new HashMap<>(16));

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> objectMap = getContext();
        Object o = objectMap.get(name);
        if (Objects.isNull(o)) {
            o = objectFactory.getObject();
            objectMap.put(name, o);
        }
        return o;
    }

    private Map<String, Object> getContext() {
        return mapThreadLocal.get();
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getContext();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
