package com.exec.business.util

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.dto.UserDTO
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:30.
 */
@Component
open class Mapper {

    fun mapUser(entity: UserEntity): UserDTO = UserDTO(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            age = entity.age,
            email = entity.email,
            sex = entity.sex
    )

    fun revertUser(dto: UserDTO): UserEntity = UserEntity(
            id = dto.id,
            firstName = dto.firstName,
            lastName = dto.lastName,
            age = dto.age,
            email = dto.email,
            sex = dto.sex,
            password = null
    )

}