package com.exec.business.config

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.thymeleaf.TemplateEngine
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ITemplateResolver

/**
 * Author: Vadym Polyanski
 * Date: 25.10.17
 * Time: 11:27
 */
@Configuration
open class ThymeleafConfiguration : WebMvcConfigurerAdapter(), ApplicationContextAware {

    private var applicationContext: ApplicationContext? = null
    private val UTF8 = "UTF-8"

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    @Bean
    @Primary
    open fun viewResolver(): ViewResolver {
        val resolver = ThymeleafViewResolver()
        resolver.templateEngine = templateEngine()
        resolver.characterEncoding = UTF8
        return resolver
    }

    private fun templateEngine(): TemplateEngine {
        val engine = SpringTemplateEngine()
        engine.setTemplateResolver(templateResolver())
        return engine
    }

    private fun templateResolver(): ITemplateResolver {
        val resolver = SpringResourceTemplateResolver()
        resolver.setApplicationContext(applicationContext)
        resolver.templateMode = TemplateMode.HTML
        return resolver
    }
}
