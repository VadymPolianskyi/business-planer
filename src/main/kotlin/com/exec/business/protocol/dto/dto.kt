package com.exec.business.protocol.dto

import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.entity.util.PlanStep

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 9:38
 */

data class UserDTO(
        val id: String?,
        val firstName: String?,
        val lastName: String?,
        val age: Int?,
        val sex: String?,
        val email: String?
)

data class BusinessPlanDTO(
        val id: String?,
        var name: String?,
        var description: String?,
        var owner: String?,
        var questions: List<QuestionDTO>?
)

data class QuestionDTO(
        val id: String?,
        var priority: Int?,
        var answer: String?,
        var type: PlanStep?
)