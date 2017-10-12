package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.UpdateBusinessPlanRequest
import com.exec.business.protocol.UpdateBusinessPlanResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:39.
 */
@Component
open class UpdateBusinessPlanHandler: BusinessPlanHandler<UpdateBusinessPlanRequest, UpdateBusinessPlanResponse>() {

    override fun handle(request: UpdateBusinessPlanRequest): UpdateBusinessPlanResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        getBusiness(request.businessPlan.id!!)

        val businessPlan = mapper.revertBusiness(request.businessPlan)

        businessService.update(businessPlan)

        LOG.info("User ${user.lastName}(${user.email}) updated his business plan (plan id - ${businessPlan.id}).")
        return UpdateBusinessPlanResponse()
    }

}