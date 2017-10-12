package com.exec.business.handler.business

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.service.BusinessService
import com.exec.business.handler.user.UserHandler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.exception.BusinessNotFoundException
import com.exec.business.util.Mapper
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:34.
 */
abstract class BusinessPlanHandler<in T : Request, out R : Response>: UserHandler<T, R>(){

    @Autowired
    internal lateinit var businessService: BusinessService

    @Autowired
    internal lateinit var mapper: Mapper

    fun getBusiness(id: String): BusinessPlanEntity {
        val business = businessService.getById(id)

        if (business == null) {
            LOG.error("Business with id $id not found.")
            throw BusinessNotFoundException("Business with id $id not found.")
        }

        LOG.info("Got businessPlan with id $id (${business.name} ${business.description} - ${business.owner}).")
        return business
    }
}