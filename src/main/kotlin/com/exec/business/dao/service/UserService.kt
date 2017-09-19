package com.exec.business.dao.service

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.repository.UserRepository
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:02.
 */
@Component
open class UserService : GenericService<UserEntity, UserRepository>() {
    fun findByEmail(email: String): UserEntity? {
        return repository.findByEmail(email)
    }
}