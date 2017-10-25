package com.exec.business.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Author: Vadym Polyanski;
 * Date: 10.09.17;
 * Time: 20:27.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }


    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http.requestMatchers()
                .antMatchers("/login/**", "/console/**", "/business-planer/main")
                .and().formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/console/**", "/business-planer/main").permitAll()
                .anyRequest().authenticated().and().httpBasic()
        http.headers().frameOptions().disable() //for h2 console work;
        http.csrf().disable()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("USER ")
    }

}