package com.example.MVCSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id , pw ,  active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id , role FROM roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configure -> configure
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/system").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(
                form -> form
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()

        ).logout(logout -> logout.permitAll()

        ).exceptionHandling(configure->configure.accessDeniedPage("/handleExc")
        );
        return http.build();
    }




//    @Bean
//    InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails ahmed = User.builder()
//                .username("ahmed")
//                .password("{noop}123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        UserDetails mohamed = User.builder()
//                .username("mohamed")
//                .password("{noop}123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails ramadan = User.builder()
//                .username("ramadan")
//                .password("{noop}123")
//                .roles("EMPLOYEE")
//                .build();
//        return new InMemoryUserDetailsManager(ahmed, mohamed, ramadan);
//    }

}
