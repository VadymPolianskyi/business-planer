package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.ContactDTO
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Author: Vadym Polyanski;
 * Date: 14.10.17;
 * Time: 12:08.
 */
data class GetContactsRequest(
        override val rotingData: RotingData,
        val businessId: String
): Request()

data class GetContactsResponse(
        val contacts: List<ContactDTO>
): Response()

//create
data class CreateContactRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val contact: ContactDTO
): Request()

class CreateContactResponse : Response()

//update
data class UpdateContactRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val contact: ContactDTO
): Request()

class UpdateContactResponse : Response()

//delete
class DeleteContactRequest(
        override val rotingData: RotingData?,
        val id: String
) : Request()

class DeleteeContactResponse : Response()

//read
data class GetContactRequest (
        override val rotingData: RotingData,
        @Valid
        @NotNull
        @NotEmpty
        val contactId: String
): Request()

data class GetContactResponse(
        val contact: ContactDTO
): Response()