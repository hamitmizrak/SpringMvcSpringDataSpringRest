package com.innova.beantuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class _03_BeanIntialDestroy {

    @Bean(initMethod = "initialBEanMethod",destroyMethod = "destroyBEanMethod")
    @Scope("request")
    public BeanDto beanInitial() {
        return BeanDto.builder().id(0L).beanData("Data pro").beanName("Adı pro").build();
    }

}