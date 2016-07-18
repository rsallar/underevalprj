package com.github.rsallar.underevalprj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

import com.github.rsallar.underevalprj.security.MongoDBAuthenticationProvider;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private MongoDBAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .formLogin()
         .loginPage("/login")
         //.loginProcessingUrl("/login/authenticate")
         //.failureUrl("/login?param.error=bad_credentials")
         .permitAll()
         .and()
         .authorizeRequests()
         .antMatchers("/favicon.ico", "/static-resources/**").permitAll()
         .antMatchers("/**").authenticated()
         //.and()
         //.rememberMe()
         .and()
         .apply(new SpringSocialConfigurer());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.authenticationProvider(authenticationProvider);
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    /*@Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new SocialClientService(userDetailsService());
    }*/
    
    
}