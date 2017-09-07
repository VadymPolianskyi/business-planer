package com.exec.business.handler.login

import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.Handler
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.RegisterRequest
import com.exec.business.protocol.RegisterResponse
import com.exec.business.util.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 07.09.17;
 * Time: 8:22.
 */
@Component
class RegisterHandler : LogHandler<RegisterRequest, RegisterResponse>() {

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var mapper: Mapper

    override fun handle(request: RegisterRequest): RegisterResponse {

        val user = mapper.revertUser(request.userDTO)
        user.password = request.password

        userService.save(user)

        LOG.info("Registered new user {} {}({})." + user.firstName, user.lastName, user.email)
        return RegisterResponse(token = "Bearer fdsjfiogj2gj03godf0jg03rg")
    }
}