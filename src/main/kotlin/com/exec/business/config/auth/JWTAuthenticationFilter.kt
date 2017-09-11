package com.exec.business.config.auth

import com.exec.business.config.jwt.TokenAuthenticationService
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

/**
 * Author: Vadym Polyanski;
 * Date: 11.09.17;
 * Time: 20:17.
 */
class JWTAuthenticationFilter : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val authentication : Authentication? = TokenAuthenticationService.getAuthentication(request = request as HttpServletRequest)

        SecurityContextHolder.getContext()
                .authentication = authentication

        chain?.doFilter(request, response)
    }

}