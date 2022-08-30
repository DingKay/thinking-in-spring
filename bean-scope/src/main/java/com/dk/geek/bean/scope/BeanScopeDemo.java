package com.dk.geek.bean.scope;

import com.dk.geek.bean.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;
import java.util.Set;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanScopeDemo implements DisposableBean {

    private static final int CYCLE_TIMES = 3;

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    // 不设置范围的情况下，默认是 singleton
    public User singletonUser() {
        return createUserByTimestamp("singleton");
    }

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User prototypeUser() {
        return createUserByTimestamp("prototype");
    }

    public static User createUserByTimestamp(String name) {
        User user = new User();
        user.setName(name);
        user.setTimestamp(System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    /**
     * resolvable dependency
     */
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    /**
     * 结论一：
     * Singleton Bean 无论是依赖查找、注入，都是一个对象
     * Prototype Bean 无论是依赖查找、注入，都是新创建的对象
     * 结论二：
     * 如果依赖注入集合对象，Singleton Bean 和 Prototype Bean 只会注入一个
     * 集合中注入的 Prototype Bean 也是一个新的对象
     * 结论三：
     * 无论是 Singleton Bean 还是 Prototype Bean 均会执行初始化方法回调
     * 不过仅 Singleton Bean 会执行销毁方法回调
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanScopeDemo.class);

        context.addBeanFactoryPostProcessor(beanFactory -> beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.printf("%s Bean 名称:%s 在初始化结束后回调 %n", bean.getClass().getName(), beanName);
                return bean;
            }
        }));

        context.refresh();

        printLookupBeansScope(context);
        printInjectionBeansScope(context);


        System.out.println("\n开始注销容器 ...");
        context.close();
    }

    private static void printInjectionBeansScope(AnnotationConfigApplicationContext context) {
        System.out.println("start printInjectionBeansScope...");
        BeanScopeDemo bean = context.getBean(BeanScopeDemo.class);
        System.out.println("bean.singletonUser = " + bean.singletonUser);
        System.out.println("bean.singletonUser1 = " + bean.singletonUser1);

        System.out.println("bean.prototypeUser = " + bean.prototypeUser);
        System.out.println("bean.prototypeUser1 = " + bean.prototypeUser1);
        System.out.println("bean.prototypeUser2 = " + bean.prototypeUser2);

        System.out.println("bean.users = " + bean.users);
    }

    private static void printLookupBeansScope(ApplicationContext context) {
        System.out.println("start printLookupBeansScope...");
        for (int i = 0; i < CYCLE_TIMES; i++) {
            User singletonUser = context.getBean("singletonUser", User.class);
            System.out.println("singletonUser = " + singletonUser);

            User prototypeUser = context.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() + " DisposableBean destroy # 开始注销中...");
        this.prototypeUser.destroyMethod();
        this.prototypeUser1.destroyMethod();
        this.prototypeUser2.destroyMethod();

        Set<Map.Entry<String, User>> entries = this.users.entrySet();
        for (Map.Entry<String, User> entry : entries) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(entry.getKey());
            if (beanDefinition.isPrototype()) {
                entry.getValue().destroyMethod();
            }
        }
        System.out.println(this.getClass().getName() + " DisposableBean destroy # 注销结束...");
    }
}
