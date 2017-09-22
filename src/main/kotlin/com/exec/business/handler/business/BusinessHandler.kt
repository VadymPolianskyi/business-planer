package com.exec.business.handler.business

import com.exec.business.dao.entity.BusinessEntity
import com.exec.business.dao.service.BusinessService
import com.exec.business.handler.user.UserHandler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.exception.BusinessNotFoundException
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:34.
 */
abstract class BusinessHandler<in T : Request, out R : Response>: UserHandler<T, R>(){

    @Autowired
    internal lateinit var businessService: BusinessService

    fun getBusiness(id: String): BusinessEntity {
        val business = businessService.getById(id)

        if (business == null) {
            LOG.error("Business with id $id not found.")
            throw BusinessNotFoundException("Business with id $id not found.")
        }

        LOG.info("Got business with id $id (${business.name} ${business.description} - ${business.owner}).")
        return business
    }
}