package com.innova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class _12_Authorization extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/index").permitAll()
                    .antMatchers("/security/public", "/security/success") //bu @GetMapping izin verdiğim url
                    .permitAll()//yukarıdaki asyfalara login olmadan izin ver
                    .antMatchers("/login").permitAll()
                    .antMatchers("/logout").permitAll()
                    .antMatchers("/security/writer").hasRole("USER")
                    .antMatchers("/security/admin").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                    .withUser("admin")
                    .password("{noop}root")
                    .roles("ADMIN","USER")
                .and()
                    .withUser("writer")
                    .password("{noop}root")
                    .roles("USER")
                .and();
    }
}
