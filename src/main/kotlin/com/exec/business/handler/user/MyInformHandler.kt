package com.exec.business.handler.user

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.Handler
import com.exec.business.protocol.MyInformRequest
import com.exec.business.protocol.MyInformResponse
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.dto.UserDTO
import com.exec.business.protocol.exception.UserNotFoundException
import com.exec.business.util.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 9:53
 */
@Component
open class MyInformHandler : Handler<MyInformRequest, MyInformResponse> {

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var mapper: Mapper

    override fun handle(request: MyInformRequest): MyInformResponse {
        val userId: String = request.rotingData.userId

        val user: UserEntity = userService.findById(userId)
                ?: throw UserNotFoundException("User with id $userId is not found.")

        val responseUser: UserDTO = mapper.mapUser(user)

        return MyInformResponse(userDTO = responseUser)
    }
}