package com.exec.business.handler.user

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.MyInformRequest
import com.exec.business.protocol.MyInformResponse
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
open class MyInformHandler : LogHandler<MyInformRequest, MyInformResponse>() {

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var mapper: Mapper

    override fun handle(request: MyInformRequest): MyInformResponse {
        val userId = request.rotingData.credentials!!.username

        val user: UserEntity? = userService.getById(userId)

        if (user == null) {
            LOG.error("User with id $userId is not found.")
            throw UserNotFoundException("User with id $userId is not found.")
        }

        val responseUser: UserDTO = mapper.mapUser(user)

        LOG.info("User {} {}({}) got own information.", user.firstName, user.lastName, user.email)
        return MyInformResponse(userDTO = responseUser)
    }
}