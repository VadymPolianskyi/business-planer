package com.exec.business

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:15.
 */
@SpringBootApplication
open class Application : SpringBootServletInitializer() {

    @Bean
    open fun mapperForKotlinTypes(): MappingJackson2HttpMessageConverter {
        return MappingJackson2HttpMessageConverter().apply { objectMapper = jacksonMapper }
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder =
            application.sources(Application::class.java)

    companion object {

        val jacksonMapper = ObjectMapper().registerKotlinModule()
                .setSerializationInclusion(JsonInclude.Include.NON_ABSENT)
                .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)

        @Throws(Exception::class)
        @JvmStatic fun main(args: Array<String>) {
            println("starting application...")
            SpringApplication.run(Application::class.java, *args)
        }
    }
}