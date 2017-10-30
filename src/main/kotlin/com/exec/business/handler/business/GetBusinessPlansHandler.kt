package com.exec.business.handler.business

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.GetBusinessPlansRequest
import com.exec.business.protocol.GetBusinessPlansResponse
import org.springframework.stereotype.Component
import kotlin.streams.toList

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:37.
 */
@Component
open class GetBusinessPlansHandler : BusinessPlanHandler<GetBusinessPlansRequest, GetBusinessPlansResponse>() {

    override fun handle(request: GetBusinessPlansRequest): GetBusinessPlansResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val businesses = businessPlanService.findByOwner(user).stream()
                .map { business -> mapper.mapBusinessPlan(business) }.toList()

        LOG.info("User ${user.lastName}(${user.email}) got his all business plans (count - ${businesses.size}).")
        return GetBusinessPlansResponse(businesses)
    }
}