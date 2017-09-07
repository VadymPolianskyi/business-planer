package com.exec.business.handler

import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.Handler
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
class RegisterHandler : Handler<RegisterRequest, RegisterResponse> {

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var mapper: Mapper

    override fun handle(request: RegisterRequest): RegisterResponse {

        val userEntity = mapper.revertUser(request.userDTO)
        userEntity.password = request.password

        userService.save(userEntity)

        return RegisterResponse(token = "Bearer fdsjfiogj2gj03godf0jg03rg")
    }
}