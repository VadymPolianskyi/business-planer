package com.exec.business.handler.question

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.CreateQuestionRequest
import com.exec.business.protocol.CreateQuestionResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:27.
 */
@Component
open class CreateQuestionHandler : QuestionHandler<CreateQuestionRequest, CreateQuestionResponse>() {

    override fun handle(request: CreateQuestionRequest): CreateQuestionResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val question = mapper.revertQuestion(request.question)

        question.businessPlan = getBusiness(request.question.businessPlan)

        questionService.save(question)

        LOG.info("User ${user.lastName}(${user.email}) created " +
                "new question (question id - ${question.id}).")
        return CreateQuestionResponse()
    }

}