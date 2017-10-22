package com.exec.business.config

import org.h2.server.web.WebServlet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Profile
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl


/**
 * Author: Vadym Polyanski;
 * Date: 22.10.17;
 * Time: 14:00.
 */
@Configuration
@EnableWebSecurity
open class ServerConfiguration{

    @Bean
    @Profile("dev")
    open fun h2servletRegistration(): ServletRegistrationBean {
        val registration = ServletRegistrationBean(WebServlet())
        registration.addUrlMappings("/console/*")
        return registration
    }

    @Bean
    open fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = "smtp.gmail.com"
        mailSender.port = 465

        mailSender.username = ""
        mailSender.password = ""

        mailSender.javaMailProperties.put("mail.transport.protocol", "smtps")
        return mailSender
    }
}