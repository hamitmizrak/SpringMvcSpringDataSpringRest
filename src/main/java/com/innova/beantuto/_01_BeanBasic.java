package com.innova.beantuto;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _01_BeanBasic {

    @Bean
    public BeanDto beanBasic(){
         return BeanDto.builder().id(0L).beanData("Data").beanName("Adı 45451").build();
    }

}
