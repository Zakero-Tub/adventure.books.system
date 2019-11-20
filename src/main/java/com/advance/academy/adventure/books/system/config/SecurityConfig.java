package com.advance.academy.adventure.books.system.config;

import com.advance.academy.adventure.books.system.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler;

    @Autowired
    public SecurityConfig(RestAuthenticationEntryPoint restAuthenticationEntryPoint, SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.savedRequestAwareAuthenticationSuccessHandler = savedRequestAwareAuthenticationSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("adminPass")).roles(UserRole.ADMIN.name())
                .and()
                .withUser("user").password(encoder().encode("userPass")).roles(UserRole.USER.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
          //      .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers(HttpMethod.POST, "/api/customer/**").hasRole(UserRole.ADMIN.name())
                .antMatchers("/api/*").authenticated()
          //
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
               .formLogin()
               .successHandler(savedRequestAwareAuthenticationSuccessHandler)
//                .failureHandler(myFailureHandler)
               .and()
               .logout();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
