package com.spring.awesome.config;

import com.spring.awesome.service.CustomUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SecurityConfig
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Habilita o PreAuthorize
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomUserDetailService customUserDetailService;

  @Autowired
  public SecurityConfig(CustomUserDetailService customUserDetailService) {
    this.customUserDetailService = customUserDetailService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();

    // Sempre mantenha um padrão de URL
    http.authorizeRequests().antMatchers("/*/protected/**").hasRole("USER").antMatchers("/*/admin/**").hasRole("ADMIN")
        .and().httpBasic().and().csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
  }

  // Autenticação em memória
  // @Autowired
  // public void configureGlobal(AuthenticationManagerBuilder auth) throws
  // Exception {
  // auth.inMemoryAuthentication().withUser("devleandrodias").password("@devpass").roles("USER").and().withUser("admin")
  // .password("@adminpass").roles("USER", "ADMIN");
  // }
}