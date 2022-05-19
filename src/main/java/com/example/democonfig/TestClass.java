package com.example.democonfig;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestClass implements InitializingBean {

    @Value("${message}")
    private String test;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(test);
    }
}
