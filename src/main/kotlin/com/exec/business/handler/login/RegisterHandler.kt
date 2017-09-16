package com.exec.business.handler.login

import com.exec.business.config.auth.AuthService
import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.dao.repository.UserDetailsRepository
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.RegisterRequest
import com.exec.business.protocol.RegisterResponse
import com.exec.business.util.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 07.09.17;
 * Time: 8:22.
 */
@Component
open class RegisterHandler : LogHandler<RegisterRequest, RegisterResponse>() {

    @Autowired
    private lateinit var authService: AuthService
    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var mapper: Mapper
    @Autowired
    private lateinit var userDetailsRepository: UserDetailsRepository


    override fun handle(request: RegisterRequest): RegisterResponse {

        val user = mapper.revertUser(request.userDTO)
        user.password = request.password

        userService.save(user)

        userDetailsRepository.save(UserCredentials(id=user.id!!, name = user.firstName!!,
                enabled = true, expired = true, locked = true))

        val token: OAuth2AccessToken = authService.login(user.id!!)

        LOG.info("Registered new user {} {}({})." + user.firstName, user.lastName, user.email)
        return RegisterResponse(token = token.value, type = token.tokenType,
                expiresIn = token.expiresIn, refresh = token.refreshToken.value)
    }
}