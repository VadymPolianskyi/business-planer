package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.DeleteBusinessPlanRequest
import com.exec.business.protocol.DeleteeBusinessPlanResponse

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:44.
 */
open class DeleteQuestionHandler : BusinessPlanHandler<DeleteBusinessPlanRequest, DeleteeBusinessPlanResponse>() {

    override fun handle(request: DeleteBusinessPlanRequest): DeleteeBusinessPlanResponse {
        val user: UserEntity = getUser(request.rotingData!!.credentials!!.id)
        getBusiness(request.id)
        businessPlanService.delete(request.id)
        LOG.info("User ${user.lastName}(${user.email}) deleted his business plan (plan id - ${request.id}).")
        return DeleteeBusinessPlanResponse()
    }

}