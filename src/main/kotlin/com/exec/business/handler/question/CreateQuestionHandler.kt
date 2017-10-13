package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.handler.question.QuestionHandler
import com.exec.business.protocol.CreateQuestionRequest
import com.exec.business.protocol.CreateQuestionResponse
import com.exec.business.protocol.CreateQuestionRequest
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

        val Question = mapper.revertQuestion(request.question)

        questionService.save(Question)

        LOG.info("User ${user.lastName}(${user.email}) created new business plan (plan id - ${Question.id}).")
        return CreateQuestionResponse()
    }

}