package com.example.democonfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class DemoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigApplication.class, args);
    }

    @Bean
    public Function<String,String> processor(){
        return (in) ->{
            log.info("PROCESSING: " + in);
            return in+ " PROCESSED";
        };
    }

    @Bean
    public Consumer<String> input(){
        return (message) -> log.info("RECIEVED: " + message);
    }

}
