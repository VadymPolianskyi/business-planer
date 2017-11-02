package com.exec.business.handler.question

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.UpdateQuestionRequest
import com.exec.business.protocol.UpdateQuestionResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:39.
 */
@Component
open class UpdateQuestionHandler : QuestionHandler<UpdateQuestionRequest, UpdateQuestionResponse>() {

    override fun handle(request: UpdateQuestionRequest): UpdateQuestionResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val business = getBusiness(request.question.businessPlan!!)
        getQuestion(request.question.id!!)

        val question = mapper.revertQuestion(request.question)

        question.businessPlan = business

        questionService.update(question)

        LOG.info("User ${user.lastName}(${user.email}) updated his question (question id - ${question.id}).")
        return UpdateQuestionResponse()
    }

}