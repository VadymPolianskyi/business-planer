package com.exec.business.handler.question

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.DeleteQuestionRequest
import com.exec.business.protocol.DeleteeQuestionResponse

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:44.
 */
open class DeleteQuestionHandler : QuestionHandler<DeleteQuestionRequest, DeleteeQuestionResponse>() {

    override fun handle(request: DeleteQuestionRequest): DeleteeQuestionResponse {
        val user: UserEntity = getUser(request.rotingData!!.credentials!!.id)
        getQuestion(request.id)//check if exist
        questionService.delete(request.id)
        LOG.info("User ${user.lastName}(${user.email}) deleted his question (question id - ${request.id}).")
        return DeleteeQuestionResponse()
    }

}