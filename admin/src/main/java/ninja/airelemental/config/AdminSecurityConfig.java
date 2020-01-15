package ninja.airelemental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class AdminSecurityConfig {

  @Configuration
  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      // @formatter:off
      http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/index.html", "/").permitAll()
        .anyRequest().hasRole("ADMIN")
        .and()
        .csrf().disable();
      // @formatter:on
    }
  }

}
