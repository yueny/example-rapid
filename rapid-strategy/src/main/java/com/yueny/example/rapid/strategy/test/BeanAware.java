package com.yueny.example.rapid.strategy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-09-04 19:46
 */
//@Service
public class BeanAware implements SmartInitializingSingleton, SmartLifecycle, InitializingBean,
        DisposableBean, BeanNameAware, ApplicationContextAware, ImportBeanDefinitionRegistrar, BeanPostProcessor {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private boolean isRunning;


    public BeanAware() {
        System.out.println("实例化");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton afterSingletonsInstantiated");
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("LifeCycle start");
    }

    @Override
    public void stop() {
        System.out.println("LifeCycle stop");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("LifeScycle stop");
        callback.run();
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterproperties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("set bean Name aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set Application Aware");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("set registerBeanDefinitions");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("对初始化之前的Bean进行处理,此时我的名字"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("对初始化之后的Bean进行处理,将Bean的成员变量的值修改了");

        return bean;
    }
}
