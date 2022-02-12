package com.innova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
public class _07_AddUSerEncryped extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
        authenticationManagerBuilder
                .inMemoryAuthentication()//bellek üzereinde olsun database düzeyde olmasın
                .withUser("root") //kullanıc adı
                .password(passwordEncoder.encode("root"))//şifrelenmiş datatdır artık
                .roles("USER");
    }

}
