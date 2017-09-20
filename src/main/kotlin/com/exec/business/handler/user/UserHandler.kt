package com.exec.business.handler.user

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.service.UserService
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 20.09.17;
 * Time: 7:17.
 */
abstract class UserHandler<in T : Request, out R : Response> : LogHandler<T, R>() {

    @Autowired
    internal lateinit var userService: UserService

    fun getUser(id: String): UserEntity {
        val user = userService.getById(id)

        if (user == null) {
            LOG.error("User with id $id not found.")
            throw UserNotFoundException("User with id $id not found.")
        }

        LOG.info("Got user with id $id (${user.firstName} ${user.lastName} - ${user.email}).")
        return user
    }
}