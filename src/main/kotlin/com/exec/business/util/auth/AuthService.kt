package com.exec.business.util.auth

import com.exec.business.protocol.exception.UserNotFoundException
import org.springframework.security.oauth2.common.OAuth2AccessToken
import javax.servlet.http.HttpServletRequest

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:13.
 */
interface AuthService {
    fun login(userId: String): OAuth2AccessToken

    @Throws(UserNotFoundException::class)//fixme: change exception
    fun logout(request: HttpServletRequest)
}