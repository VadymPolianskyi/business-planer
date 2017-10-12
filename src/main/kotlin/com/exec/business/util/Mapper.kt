package com.exec.business.util

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.dto.BusinessPlanDTO
import com.exec.business.protocol.dto.QuestionDTO
import com.exec.business.protocol.dto.UserDTO
import org.springframework.stereotype.Component
import kotlin.streams.toList

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

    fun mapBusiness(planEntity: BusinessPlanEntity): BusinessPlanDTO = BusinessPlanDTO(
            id = planEntity.id,
            name = planEntity.name,
            description = planEntity.description,
            owner = planEntity.owner!!.id,
            questions = planEntity.questions!!.stream().map { question -> mapQuestion(question) }.toList()
    )

    fun revertBusiness(planDto: BusinessPlanDTO): BusinessPlanEntity = BusinessPlanEntity(
            id = planDto.id,
            name = planDto.name,
            description = planDto.description
    )

    fun mapQuestion(entity: QuestionEntity): QuestionDTO = QuestionDTO(
            id = entity.id,
            priority = entity.priority,
            answer = entity.answer,
            type = entity.type
    )

    fun revertQuestion(planDto: BusinessPlanDTO): BusinessPlanEntity = BusinessPlanEntity(
            id = planDto.id,
            name = planDto.name,
            description = planDto.description
    )

}