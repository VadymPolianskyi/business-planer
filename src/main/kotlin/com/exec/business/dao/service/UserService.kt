package com.exec.business.dao.service

import com.exec.business.dao.entity.UserEntity

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:02.
 */
interface UserService : GenericService<String, UserEntity> {

    fun findByEmail(email: String): UserEntity?

}