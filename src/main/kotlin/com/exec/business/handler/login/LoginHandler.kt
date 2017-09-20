package com.exec.business.handler.login

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.LoginRequest
import com.exec.business.protocol.LoginResponse
import com.exec.business.protocol.exception.UserNotFoundException
import com.exec.business.protocol.exception.WrongPasswordException
import com.exec.business.util.auth.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:37.
 */
@Component
open class LoginHandler : LogHandler<LoginRequest, LoginResponse>() {

    @Autowired
    private lateinit var authService: AuthService
    @Autowired
    private lateinit var userService: UserService

    override fun handle(request: LoginRequest): LoginResponse {

        val user: UserEntity = userService.findByEmail(request.login)
                    ?: throw UserNotFoundException("User with email ${request.login} is not found.")

        if (user.password != request.password) {
            LOG.error("Password '{}' is wrong for user with login '{}'..", request.password, request.login)
            throw WrongPasswordException("Password '${request.password}' is wrong for user with login '${request.login}'..")
        }

        val token = authService.login(user.id!!)

        LOG.info("Authenticated user {} {}({}).", user.firstName, user.lastName, user.email)
        return LoginResponse(token = token.value, type = token.tokenType,
                expiresIn = token.expiresIn, refresh = token.refreshToken.value)
    }
}
