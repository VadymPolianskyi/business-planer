package com.exec.business.handler.question

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.CreateQuestionRequest
import com.exec.business.protocol.CreateQuestionResponse
import com.exec.business.util.DeadLineNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:27.
 */
@Component
open class CreateQuestionHandler : QuestionHandler<CreateQuestionRequest, CreateQuestionResponse>() {


    @Autowired
    private lateinit var notificationService: DeadLineNotificationService

    override fun handle(request: CreateQuestionRequest): CreateQuestionResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val question = mapper.revertQuestion(request.question)

        if(question.deadline == null) {
            question.deadline = System.currentTimeMillis() + 10000
        }

        question.businessPlan = getBusiness(request.question.businessPlan)

        questionService.save(question)

        notificationService.addNotificationTask(question, user)

        LOG.info("User ${user.lastName}(${user.email}) created " +
                "new question (question id - ${question.id}).")
        return CreateQuestionResponse()
    }

}