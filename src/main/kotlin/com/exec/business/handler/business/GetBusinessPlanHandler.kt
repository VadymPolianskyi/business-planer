package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.GetBusinessPlanRequest
import com.exec.business.protocol.GetBusinessPlanResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:16.
 */
@Component
open class GetBusinessPlanHandler : BusinessPlanHandler<GetBusinessPlanRequest, GetBusinessPlanResponse>() {

    override fun handle(request: GetBusinessPlanRequest): GetBusinessPlanResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val businessPlan = getBusiness(request.planId)

        LOG.info("User ${user.lastName}(${user.email}) got his business plan (plan id - ${businessPlan.id}).")
        return GetBusinessPlanResponse(businessPlan = mapper.mapBusinessPlan(businessPlan))
    }

}