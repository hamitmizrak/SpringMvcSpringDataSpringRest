package com.innova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Auditing aktif etmek için
@EnableJpaAuditing  // Update/insert kim ve ne zaman yaptını kayıtını tutan Entity sınıfı
@SpringBootApplication
public class SpringMvcSpringDataSpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSpringDataSpringRestApplication.class, args);
    }

}
