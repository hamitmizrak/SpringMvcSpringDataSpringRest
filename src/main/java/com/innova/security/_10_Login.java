package com.innova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class _10_Login extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/security/public","/security/success") //bu @GetMapping izin verdiğim url
               .permitAll()//yukarıdaki asyfalara login olmadan izin ver
               .antMatchers("/login").permitAll()
               .anyRequest()
               .authenticated()
               .and()
               .formLogin()
               .loginPage("/login")
               .defaultSuccessUrl("/security/private")
               .and();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("root")
                .password("{noop}root")
                .roles("USER");
    }
}
