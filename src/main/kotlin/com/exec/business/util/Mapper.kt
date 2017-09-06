package com.exec.business.util

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.dto.UserDTO
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:30.
 */
@Component
class Mapper (
        private val mapper: ModelMapper = ModelMapper()
) {

    fun mapUser(userEntity: UserEntity): UserDTO {
        return mapper.map(userEntity, UserDTO::class.java)
    }

    fun revertUser(userDTO: UserDTO): UserEntity {
        return mapper.map(userDTO, UserEntity::class.java)
    }
}