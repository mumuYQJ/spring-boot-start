package com.csdj.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( requests -> {
            requests.requestMatchers("/").permitAll()
                    .anyRequest().authenticated();
        });
        http.formLogin(formLoginConfigurer -> {
            formLoginConfigurer.loginPage("/login").permitAll();
        });
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN", "HR")
                .authorities("read_file", "write_file", "delete_file").build();

        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123"))
                .roles("HR")
                .authorities("read_file").build();

        UserDetails wangwu = User.withUsername("wangwu")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN")
                .authorities("write_file").build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(zhangsan,lisi,wangwu);
        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
