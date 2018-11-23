package com.fubailin.tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//In-memory user store
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("buzz")
//                .password(new BCryptPasswordEncoder().encode("infinity"))
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("woody")
//                .password(new BCryptPasswordEncoder().encode("bullseye"))
//                .authorities("ROLE_USER");

//JDBC-based user store
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());

//LDAP-backed user store
//        auth.ldapAuthentication().contextSource().url("ldap://tacocloud.com:389/dc=tacocloud,dc=com");
//        auth.ldapAuthentication()
//            .userSearchBase("ou=people")
//            .userSearchFilter("(uid={0})")
//            .groupSearchBase("ou=groups")
//            .groupSearchFilter("member={0}")
//            .passwordCompare()
//            .passwordEncoder(new BCryptPasswordEncoder());

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design")

                .and()
                .logout()
                .logoutSuccessUrl("/");

    }
}
