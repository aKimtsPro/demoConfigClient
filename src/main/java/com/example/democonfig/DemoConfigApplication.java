package com.example.democonfig;

import com.example.democonfig.model.Personne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class DemoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigApplication.class, args);
    }

    @Bean
    // output-out-0
    public Supplier<Personne> output(){
        return () -> new Personne("dubois","luc");
    }

    @Bean
    // processor-in-0
    // processor-out-0
    public Function<Personne,Personne> processor(){
        return (in) ->{
            log.info("PROCESSING: " + in);
            in.setNom("PROCESSED: " + in.getNom());
            return in;
        };
    }

    @Bean
    // input-in-0
    public Consumer<String> input(){
        return (personne) -> log.info("RECIEVED: " + personne);
    }

}
