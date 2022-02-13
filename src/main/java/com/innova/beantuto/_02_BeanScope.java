package com.innova.beantuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class _02_BeanScope {

    @Bean
// @Scope("singleton") // Default olandır proje başlarken Init ve destroy çalışır default olandır projeyi kapattığımda ölür
// @Scope("request")   // sadece Tek istekte  atıldığında yaşar ve ölür
// @Scope("session")   // oturum kapatıldığında ölür
// @Scope("prototype") // Clone oluşurur başlarken 2 tanedir

    public BeanDto beanScope() {
        return BeanDto.builder().id(0L).beanData("Data pro").beanName("Adı pro").build();
    }

}