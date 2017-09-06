package com.exec.business.handler

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.protocol.LoginRequest
import com.exec.business.protocol.LoginResponse
import com.exec.business.protocol.exception.UserNotFoundException
import com.exec.business.protocol.exception.WrongPasswordException
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:37.
 */
@Component
class LoginHandler (
        private val userService: UserService
        ) : Handler<LoginRequest, LoginResponse> {

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
