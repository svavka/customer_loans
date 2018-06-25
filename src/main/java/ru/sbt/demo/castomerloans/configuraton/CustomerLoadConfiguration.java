package ru.sbt.demo.castomerloans.configuraton;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerLoadConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }




}
