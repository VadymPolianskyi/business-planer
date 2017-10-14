package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.handler.question.CreateQuestionHandler
import com.exec.business.handler.question.GetQuestionsHandler
import com.exec.business.handler.factory.Factory
import com.exec.business.handler.question.DeleteQuestionHandler
import com.exec.business.handler.question.UpdateQuestionHandler
import com.exec.business.protocol.CreateQuestionRequest
import com.exec.business.protocol.DeleteQuestionRequest
import com.exec.business.protocol.GetQuestionsRequest
import com.exec.business.protocol.UpdateQuestionRequest
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:03.
 */
@RestController
@RequestMapping("/login")
class QuestionController {
    @Autowired
    private lateinit var factory: Factory

    @GetMapping("/{planId}")
    fun getQuestions(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable planId: String
    ): Response {
        val request = GetQuestionsRequest(RotingData(credentials), planId)
        return factory.get(GetQuestionsHandler::class.java).handle(request)
    }

    @PutMapping
    fun updateQuestion(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: UpdateQuestionRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(UpdateQuestionHandler::class.java).handle(request)
    }

    @PostMapping
    fun createQuestion(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: CreateQuestionRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(CreateQuestionHandler::class.java).handle(request)
    }

    @DeleteMapping("/{id}")
    fun deleteQuestion(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = DeleteQuestionRequest(RotingData(credentials), id)

        return factory.get(DeleteQuestionHandler::class.java).handle(request)
    }
}
