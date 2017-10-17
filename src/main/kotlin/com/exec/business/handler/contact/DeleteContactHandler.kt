package com.exec.business.handler.contact

import com.exec.business.dao.entity.UserEntity
import com.exec.business.protocol.DeleteContactRequest
import com.exec.business.protocol.DeleteeContactResponse

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 22:44.
 */
open class DeleteContactHandler : ContactHandler<DeleteContactRequest, DeleteeContactResponse>() {

    override fun handle(request: DeleteContactRequest): DeleteeContactResponse {
        val user: UserEntity = getUser(request.rotingData!!.credentials!!.id)
        getContact(request.id)
        contactService.delete(request.id)
        LOG.info("User ${user.lastName}(${user.email}) deleted his contact (contact id - ${request.id}).")
        return DeleteeContactResponse()
    }

}