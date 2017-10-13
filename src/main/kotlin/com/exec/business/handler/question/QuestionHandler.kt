package com.exec.business.handler.question

import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.service.QuestionService
import com.exec.business.handler.business.BusinessPlanHandler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.exception.QuestionNotFoundException
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:09.
 */
abstract class QuestionHandler<in T : Request, out R : Response>: BusinessPlanHandler<T, R>(){

    @Autowired
    internal lateinit var questionService: QuestionService

    fun getQuestion(id: String): QuestionEntity {
        val question = questionService.getById(id)

        if (question == null) {
            LOG.error("Question with id $id not found.")
            throw QuestionNotFoundException("Question with id $id not found.")
        }

        LOG.info("Got question with id $id (${question.type} - ${question.businessPlan!!.id}).")
        return question
    }
}