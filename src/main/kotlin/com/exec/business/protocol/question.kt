package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.QuestionDTO
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:05.
 */

data class GetQuestionsRequest(
        override val rotingData: RotingData,
        @Valid
        @NotNull
        @NotEmpty
        val planId: String
): Request()

data class GetQuestionsResponse(
        val ouestions: List<QuestionDTO>
): Response()

//create
data class CreateQuestionRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val question: QuestionDTO,
        @Valid
        @NotNull
        val planId: String
): Request()

class CreateQuestionResponse : Response()

//update
data class UpdateQuestionRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val Question: QuestionDTO
): Request()

class UpdateQuestionResponse : Response()

//delete
class DeleteQuestionRequest(
        override val rotingData: RotingData?,
        val id: String
) : Request()

class DeleteeQuestionResponse : Response()