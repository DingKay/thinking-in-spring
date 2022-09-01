package com.dk.geek.bean.scope;

import com.dk.geek.bean.annotation.MyThreadLocal;
import com.dk.geek.bean.config.ConfigureDemo;
import com.dk.geek.bean.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dkay
 * @version 1.0
 */
@Slf4j
public class CustomScopeDemo {
    public static final AtomicInteger COUNTER = new AtomicInteger(0);
    public static final ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(3,3,10, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(5), (Runnable r) -> {
        Thread thread = new Thread(r);
        thread.setName("ThreadScope-Pool-Demo-" + COUNTER.getAndIncrement());
        return thread;
    });

    public static final Integer FREQUENCY = 7;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigureDemo.class);
        context.addBeanFactoryPostProcessor(beanFactory -> beanFactory.registerScope(MyThreadLocal.THREAD_SCOPE_NAME, new MyThreadLocal()));
        context.refresh();

        CountDownLatch count = new CountDownLatch(FREQUENCY);
        for (int i = 0; i < FREQUENCY; i++) {
            POOL_EXECUTOR.execute(() -> {
                User bean = context.getBean(User.class);
                System.out.printf("Thread Name:%s, Thread Id:%s, Bean:%s%n", Thread.currentThread().getName(),
                        Thread.currentThread().getId(), bean);
                log.debug("Thread Name:{}, Thread Id:{}, Bean:{}", Thread.currentThread().getName(),
                        Thread.currentThread().getId(), bean);
                count.countDown();
            });
        }


        try {
            // 不关闭线程池，会导致jvm不会自动推出
            POOL_EXECUTOR.shutdown();
            count.await();
        } catch (Exception e) {
            log.error("occur an error", e);
        }

        context.close();
    }
}
