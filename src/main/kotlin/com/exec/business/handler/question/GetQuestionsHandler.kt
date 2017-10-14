package com.exec.business.handler.question

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.GetQuestionsRequest
import com.exec.business.protocol.GetQuestionsResponse
import org.springframework.stereotype.Component
import kotlin.streams.toList

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:37.
 */
@Component
open class GetQuestionsHandler : QuestionHandler<GetQuestionsRequest, GetQuestionsResponse>() {

    override fun handle(request: GetQuestionsRequest): GetQuestionsResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val businessPlan = getBusiness(request.planId)

        val questions = questionService.findByBusinessPlan(businessPlan).stream()
                .map { question -> mapper.mapQuestion(question) }.toList()

        LOG.info("User ${user.lastName}(${user.email}) got his all business plans (count - ${questions.size}).")
        return GetQuestionsResponse(questions)
    }
}