package com.auctionweb.auction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.auctionweb.auction.user.MyUserDetsService;

//How spring security flow works to save a User:
//  1-AuthenticationManager: delegates auth to
//  2-AuthenticationProvider: that uses
//  3-MyUserDetsServ: (my impl of the original interface) loads the
//  4-UserDetails or UserPrincipal: stored in
//  5-SecurityContext (HttpSession)

//How it goes:
//  1-User submits login form.
//  2-Spring Security calls DaoAuthenticationProvider.
//  3-It calls MyUserDetsServ.loadUserByUsername().
//  4-That returns UserPrincipal (which implements UserDetails).
//  5-Spring Security checks the password & roles.
//  6-On success, it stores the UserPrincipal in the SecurityContext.

//Objective: set the filter chain such that the endpoint for register and home are not protected and,
//thats it...

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetsService uds;

    @Bean
    public SecurityFilterChain scf(HttpSecurity http) throws Exception{

        return http
            .csrf(customizer -> customizer.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/", "/postRegister", "/userRegister")
                .permitAll().anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
    @Bean
    public AuthenticationProvider authProv(){
        DaoAuthenticationProvider daoAuthProv = new DaoAuthenticationProvider();

        daoAuthProv.setPasswordEncoder(new BCryptPasswordEncoder(10));
        daoAuthProv.setUserDetailsService(uds);

        return daoAuthProv;
    }

    @Bean
    public AuthenticationManager authMan(AuthenticationConfiguration authConf) throws Exception{
        return authConf.getAuthenticationManager();
    }
}


