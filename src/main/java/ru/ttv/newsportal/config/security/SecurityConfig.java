package ru.ttv.newsportal.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login, password, true from np_company where login=?")
                .authoritiesByUsernameQuery("select a.login, r.name from np_role r JOIN np_company a ON r.id=a.role_id WHERE a.login=?");
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/adv/*/edit").hasAuthority("admin")
                .antMatchers(HttpMethod.GET,"/adv/add").hasAnyAuthority("admin","user")
                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("login").passwordParameter("password").failureUrl("/loginfailed")
                .and().logout().logoutSuccessUrl("/");
    }



    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
