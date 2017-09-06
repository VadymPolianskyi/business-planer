package com.exec.business.dao.service.impl

import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.repository.UserRepository
import com.exec.business.dao.service.UserService
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:09.
 */
@Component
class UserServiceImpl(private val repository: UserRepository) : UserService {

    override fun findByEmail(email: String): UserEntity? {
        return repository.findByEmail(email)
    }

    override fun save(entity: UserEntity): UserEntity? {
        return repository.save(entity)
    }

    override fun update(entity: UserEntity): UserEntity? {
        return repository.save(entity)
    }

    override fun delete(id: String) {
        repository.delete(id)
    }

    override fun findById(id: String): UserEntity? {
        return repository.findOne(id)
    }

    override fun findAll(): List<UserEntity> {
        return repository.findAll()
    }

}