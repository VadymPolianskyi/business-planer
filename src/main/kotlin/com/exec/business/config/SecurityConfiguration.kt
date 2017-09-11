package com.exec.business.config

import com.exec.business.config.auth.JWTAuthenticationFilter
import com.exec.business.config.auth.JWTLoginFilter
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder



/**
 * Author: Vadym Polyanski;
 * Date: 10.09.17;
 * Time: 20:27.
 */
@Configuration
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter::class.java)
                .addFilterBefore(JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter::class.java)
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        // Create a default account
        auth!!.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN")
    }

}