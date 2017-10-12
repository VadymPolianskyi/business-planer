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

    fun mapBusinessPlan(entity: BusinessPlanEntity): BusinessPlanDTO = BusinessPlanDTO(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            owner = entity.owner!!.id,
            questions = entity.questions!!.stream().map { question -> mapQuestion(question) }.toList()
    )

    fun revertBusinessPlan(dto: BusinessPlanDTO): BusinessPlanEntity = BusinessPlanEntity(
            id = dto.id,
            name = dto.name,
            description = dto.description
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