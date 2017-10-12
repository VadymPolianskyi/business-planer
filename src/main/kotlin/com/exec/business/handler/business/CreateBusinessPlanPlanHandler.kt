package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.CreateBusinessPlanRequest
import com.exec.business.protocol.CreateBusinessPlanResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:27.
 */
@Component
open class CreateBusinessPlanPlanHandler : BusinessPlanHandler<CreateBusinessPlanRequest, CreateBusinessPlanResponse>() {

    override fun handle(request: CreateBusinessPlanRequest): CreateBusinessPlanResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val businessPlan = mapper.revertBusinessPlan(request.businessPlan)

        businessPlanService.save(businessPlan)

        LOG.info("User ${user.lastName}(${user.email}) created new business plan (plan id - ${businessPlan.id}).")
        return CreateBusinessPlanResponse()
    }

}