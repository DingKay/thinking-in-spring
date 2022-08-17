package com.dk.geek.lookup;

import com.dk.geek.domain.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * @author dkay
 * @version 1.0
 */
public class SafetyLookupDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SafetyLookupDemo.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        // get single
        // unsafety
        displayUnSafetyLookupBeanByBeanFactory(context, Worker.class);
        displayUnsafetyLookupBeanByObjectFactory(context);

        // safety
        displaySafeTyLookupBeanByGetIfAvailable(context,
                () -> Worker.builder().age(22).name("worker-1").build());

        // get collection
        // safety
        displaySafetyLookupBeanByStreamOps(context);
        displaySafetyLookupBeanByListableBeanFactory(context, Worker.class);
    }

    private static void displaySafetyLookupBeanByListableBeanFactory(BeanFactory context, Class<Worker> type) {
        System.out.println("displaySafetyLookupBeanByListableBeanFactory ...");
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            listableBeanFactory.getBeansOfType(type);
        }
    }

    private static void displaySafetyLookupBeanByStreamOps(BeanFactory beanFactory) {
        System.out.println("displaySafetyLookupBeanByStreamOps ...");
        doSomething(() -> beanFactory.getBeanProvider(Worker.class).stream().forEach(System.out::println));
    }

    private static void displaySafeTyLookupBeanByGetIfAvailable(BeanFactory beanFactory,
                                                                Supplier<Worker> supplier) {
        System.out.println("displaySafeTyLookupBeanByGetIfAvailable ...");
        doSomething(() -> beanFactory.getBeanProvider(Worker.class).getIfAvailable(supplier));
    }

    public static void displayUnSafetyLookupBeanByBeanFactory(BeanFactory beanFactory, Class<Worker> type) {
        System.out.println("displayUnSafetyLookupBeanByBeanFactory ...");
        doSomething(() -> beanFactory.getBean(type));
    }

    public static void displayUnsafetyLookupBeanByObjectFactory(BeanFactory beanFactory) {
        System.out.println("displayUnsafetyLookupBeanByObjectFactory ...");
        doSomething(beanFactory.getBeanProvider(Worker.class)::getObject);
    }

    public static void doSomething(WrapperRun run) {
        try {
            run.go();
        } catch (Exception e) {
            LOGGER.error("doSomething Wrapper run.go occur an error", e);
        }
    }

    @FunctionalInterface
    public interface WrapperRun {

        /**
         * wrapper do something task
         */
        void go();
    }
}
