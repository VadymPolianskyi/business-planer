package com.exec.business.handler

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.Handler
import com.exec.business.protocol.LoginRequest
import com.exec.business.protocol.LoginResponse
import com.exec.business.protocol.exception.UserNotFoundException
import com.exec.business.protocol.exception.WrongPasswordException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:37.
 */
@Component
open class LoginHandler : Handler<LoginRequest, LoginResponse> {

    @Autowired
    private lateinit var userService: UserService

    override fun handle(request: LoginRequest): LoginResponse {
        val userEntity: UserEntity = userService.findByEmail(request.login)
                    ?: throw UserNotFoundException("User with email ${request.login} is not found.")

        val userPassword = userEntity.password

        if (userPassword != request.password) {
            throw WrongPasswordException("Password '" + request.password +
                    "' is wrong for user with login '" + request.login + "'..")
        }

        return LoginResponse(token = "Bearer fdsiof20gg02gbnfswoiskvj52")
    }
}
