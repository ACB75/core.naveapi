package com.w2m.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecConf {

      @Bean
      public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                  .authorizeHttpRequests(authorizeRequests ->
                          authorizeRequests
                                  .requestMatchers("/h2-console/**").permitAll()
                                  .requestMatchers("/api/**").permitAll()
                                  .requestMatchers("/**").permitAll()
                  );
                  //.formLogin(withDefaults());
          return http.build();
      }
      public UserDetailsService userDetailsService() {
            PasswordEncoder encoder = passwordEncoder();
            UserDetails user = User.builder()
                  .username("user")
                  .password(encoder.encode("user"))
                  .roles("USER")
                  .build();
          UserDetails admin = User.builder()
                  .username("admin")
                  .password(encoder.encode("admin123"))
                  .roles("ADMIN", "USER")
                  .build();
          return new InMemoryUserDetailsManager(user, admin);
      }

      @Bean
      public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
      }
}
