package ru.sbt.demo.castomerloans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomerLoansApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CustomerLoansApplication.class, args);
    }


}
