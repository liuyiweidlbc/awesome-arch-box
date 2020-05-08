package com.openmindstorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BehavioralApplication {


    @Autowired
    private static ApplicationContext applicationContext = null;

    public static <T>  T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(BehavioralApplication.class, args);
    }

}
