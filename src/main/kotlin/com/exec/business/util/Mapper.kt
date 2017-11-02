package com.exec.business.util

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.ContactEntity
import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.entity.util.PlanStep
import com.exec.business.protocol.dto.BusinessPlanDTO
import com.exec.business.protocol.dto.ContactDTO
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
            description = dto.description,
            questions = dto.questions!!.stream().map{question ->  revertQuestion(question)}.toList()
    )

    fun mapQuestion(entity: QuestionEntity): QuestionDTO = QuestionDTO(
            id = entity.id,
            businessPlan = entity.businessPlan!!.id!!,
            priority = entity.priority,
            answer = entity.answer,
            deadline = entity.deadline,
            type = entity.type.number
    )

    fun revertQuestion(dto: QuestionDTO): QuestionEntity = QuestionEntity(
            id = dto.id,
            businessPlan = null,
            priority = dto.priority,
            answer = dto.answer,
            deadline = dto.deadline?: 1609286400,
            type = PlanStep.values()[dto.type!!-1]
    )

    fun mapContact(entity: ContactEntity): ContactDTO = ContactDTO(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            phoneNumber = entity.phoneNumber,
            planId = entity.plan!!.id,
            role = entity.role
    )

    fun revertContact(dto: ContactDTO): ContactEntity = ContactEntity(
            id = dto.id,
            name = dto.name,
            email = dto.email,
            phoneNumber = dto.phoneNumber,
            plan = null,
            role = dto.role
    )

}