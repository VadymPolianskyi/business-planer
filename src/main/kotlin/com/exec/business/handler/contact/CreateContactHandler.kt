package com.exec.business.handler.contact

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.CreateContactRequest
import com.exec.business.protocol.CreateContactResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:27.
 */
@Component
open class CreateContactHandler : ContactHandler<CreateContactRequest, CreateContactResponse>() {

    override fun handle(request: CreateContactRequest): CreateContactResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val contact = mapper.revertContact(request.contact)

        contactService.save(contact)

        LOG.info("User ${user.lastName}(${user.email}) added new contact (contact name - ${contact.name}).")
        return CreateContactResponse()
    }

}