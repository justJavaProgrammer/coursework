package edu.odeyalo.college.coursework.config;

import edu.odeyalo.college.coursework.web.security.filter.JwtTokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfiguration {
    private final UserDetailsService userDetailsService;
    private final JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

    public WebSecurityConfiguration(UserDetailsService userDetailsService, JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenAuthenticationFilter = jwtTokenAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain httpSecurity(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/cards/create").hasAuthority("COMMANDANT")
                .anyRequest().permitAll()
                .and()
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
