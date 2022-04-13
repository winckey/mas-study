package com.example.userservice.security;

import com.example.userservice.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Environment env;



    @Override// 시큐리티가 필터앞에 동작할때 comfigure 함수가 동작한다.
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll();


//        http.authorizeRequests().antMatchers("/users")
//                .hasIpAddress(env.getProperty("gateway.ip")) // <- IP 변경
//                .and()
//                .addFilter(getAuthenticationFilter());
//
//        http.authorizeRequests().anyRequest().denyAll();

        http.headers().frameOptions().disable();
        //h2-console접근을 위한 설정정
   }

}
