package com.exec.business.handler.contact

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.UpdateContactRequest
import com.exec.business.protocol.UpdateContactResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:39.
 */
@Component
open class UpdateContactHandler : ContactHandler<UpdateContactRequest, UpdateContactResponse>() {

    override fun handle(request: UpdateContactRequest): UpdateContactResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val businessPlan = getBusiness(request.contact.planId!!)

        val contact = mapper.revertContact(request.contact)

        contact.plan = businessPlan
        contactService.update(contact)

        LOG.info("User ${user.lastName}(${user.email}) updated his business plan (contact name - ${contact.name}).")
        return UpdateContactResponse()
    }

}