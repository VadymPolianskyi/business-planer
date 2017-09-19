package com.exec.business.dao.repository

import com.exec.business.dao.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 21:58.
 */

interface UserRepository: BaseRepository<UserEntity> {
    fun findByEmail(email: String) : UserEntity?
}