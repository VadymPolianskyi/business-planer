package com.exec.business.config.auth

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*
import com.exec.business.config.jwt.TokenAuthenticationService
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.FilterChain




/**
 * Author: Vadym Polyanski;
 * Date: 11.09.17;
 * Time: 20:09.
 */
class JWTLoginFilter(url: String, authManager: AuthenticationManager) :
        AbstractAuthenticationProcessingFilter(AntPathRequestMatcher(url)) {

    init {
        authenticationManager = authManager
    }

    override fun attemptAuthentication(req: HttpServletRequest, resp: HttpServletResponse): Authentication {
        val creds = ObjectMapper()
                .readValue(req.inputStream, AccountCredentials::class.java)
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        creds.login,
                        creds.password,
                        Collections.emptyList()
                )
        )
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse, chain: FilterChain?,
            auth: Authentication) {

        TokenAuthenticationService
                .addAuthentication(res, auth.name)
    }

}