package com.exec.business.handler.contact

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.GetContactRequest
import com.exec.business.protocol.GetContactResponse
import com.exec.business.protocol.GetContactsRequest
import com.exec.business.protocol.GetContactsResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:37.
 */
@Component
open class GetContactHandler : ContactHandler<GetContactRequest, GetContactResponse>() {

    override fun handle(request: GetContactRequest): GetContactResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val contact = getContact(request.contactId)

        LOG.info("User ${user.lastName}(${user.email}) got his contact plan (contact name - ${contact.name}).")
        return GetContactResponse(contact = mapper.mapContact(contact))
    }
}