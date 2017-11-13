package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.QuestionDTO
import org.hibernate.validator.constraints.NotEmpty
import java.util.stream.Stream
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
        val questions: List<QuestionDTO>
): Response()

//create
data class CreateQuestionRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val question: QuestionDTO
): Request()

class CreateQuestionResponse : Response()

//update
data class UpdateQuestionRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val question: QuestionDTO
): Request()

class UpdateQuestionResponse : Response()

//delete
class DeleteQuestionRequest(
        override val rotingData: RotingData?,
        val id: String
) : Request()

class DeleteeQuestionResponse : Response()

class AllTypesRequest(
        override val rotingData: RotingData?
) : Request()

data class AllTypesResponse(
        val types: List<String>
): Response()

