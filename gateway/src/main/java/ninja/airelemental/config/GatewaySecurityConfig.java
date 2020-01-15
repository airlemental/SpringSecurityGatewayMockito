package ninja.airelemental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class GatewaySecurityConfig {

  @Configuration
  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
      // @formatter:off
      auth.inMemoryAuthentication()
        .withUser("user").password("password").roles("USER")
        .and()
        .withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
        .and()
        .withUser("audit").password("audit").roles("USER", "ADMIN", "READER")
        .and()
        .withUser("Wind").password("B031ng777").roles("USER", "ADMIN", "READER", "WRITER");
// @formatter:on
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      // @formatter:off
      http
        .httpBasic().and()
        .logout().and()
        .authorizeRequests()
        .antMatchers("/index.html", "/").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
      // @formatter:on
    }
  }

}
