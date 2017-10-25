package com.exec.business.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

/**
 * Author: Vadym Polyanski;
 * Date: 17.09.17;
 * Time: 12:46.
 */
@Configuration
@EnableResourceServer
open class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/login/**", "/console/**", "/business-planer/main").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().and().httpBasic()
        http.headers().frameOptions().disable()//for h2 console work;
    }
}