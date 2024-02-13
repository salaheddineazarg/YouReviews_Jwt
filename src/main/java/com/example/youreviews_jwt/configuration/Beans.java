package com.example.youreviews_jwt.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }


}