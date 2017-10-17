package com.exec.business.handler.contact

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.GetContactsRequest
import com.exec.business.protocol.GetContactsResponse
import org.springframework.stereotype.Component
import kotlin.streams.toList

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:37.
 */
@Component
open class GetContactsHandler : ContactHandler<GetContactsRequest, GetContactsResponse>() {

    override fun handle(request: GetContactsRequest): GetContactsResponse {
        val user: UserEntity = getUser(request.rotingData.credentials!!.id)

        val plan = getBusiness(request.businessId)

        val contacts = contactService.findByPlan(plan).stream()
                .map { contact -> mapper.mapContact(contact) }.toList()

        LOG.info("User ${user.lastName}(${user.email}) got his contacts (count - ${contacts.size}).")
        return GetContactsResponse(contacts)
    }
}