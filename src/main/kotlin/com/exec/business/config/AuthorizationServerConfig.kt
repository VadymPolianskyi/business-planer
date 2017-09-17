package com.exec.business.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import javax.sql.DataSource

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 22:51.
 */
@Configuration
@EnableAuthorizationServer
open class AuthorizationServerConfig: AuthorizationServerConfigurerAdapter() {


    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var userDetailsService: UserDetailsService
    @Autowired
    private lateinit var dataSource: DataSource


    @Value("\${token.validity.seconds}")
    private val tokenValiditySeconds: Int = 0

    @Throws(Exception::class)
    override fun configure(security: AuthorizationServerSecurityConfigurer) {
        security.checkTokenAccess("isAuthenticated()")
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory().withClient("my-trusted-client")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read", "write", "trust")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(tokenValiditySeconds)
                .secret("secret")
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authenticationManager(authenticationManager)
        //JWT
        endpoints.userDetailsService(userDetailsService)
        endpoints.tokenStore(tokenStore())
        endpoints.accessTokenConverter(accessTokenConverter())
    }


    @Bean
    open fun tokenStore(): TokenStore {
        return JdbcTokenStore(dataSource)
    }

    @Bean
    open fun accessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey("signing-key")
        (converter.accessTokenConverter as DefaultAccessTokenConverter)
                .setUserTokenConverter(userAuthenticationConverter())
        return converter
    }

    @Bean
    open fun userAuthenticationConverter(): UserAuthenticationConverter {
        val defaultUserAuthenticationConverter = DefaultUserAuthenticationConverter()
        defaultUserAuthenticationConverter.setUserDetailsService(userDetailsService)
        return defaultUserAuthenticationConverter
    }
}