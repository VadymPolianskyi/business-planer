package com.exec.business.config.auth

import com.exec.business.protocol.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:16.
 */
@Service
class AuthServiceImpl : AuthService {

    @Autowired
    private lateinit var oAuth2Service: OAuth2Service

    override fun login(userId: String): OAuth2AccessToken {
        return oAuth2Service.getAccess(userId)

    }

    override fun logout(request: HttpServletRequest) {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        val replace: String
        if (authHeader != null) {
            replace = when {
                authHeader.contains("Bearer") -> "Bearer"
                authHeader.contains("bearer") -> "bearer"
                else -> throw UserNotFoundException("Can't find token")
            }
            val tokenValue = authHeader.replace(replace, "").trim({ it <= ' ' })
            oAuth2Service.revokeToken(tokenValue)
        }
    }

}