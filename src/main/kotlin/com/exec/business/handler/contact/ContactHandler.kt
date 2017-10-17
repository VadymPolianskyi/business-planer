package com.exec.business.handler.contact

import com.exec.business.dao.entity.ContactEntity
import com.exec.business.dao.service.ContactService
import com.exec.business.handler.business.BusinessPlanHandler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.exception.ContactNotFoundException
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:34.
 */
abstract class ContactHandler<in T : Request, out R : Response>: BusinessPlanHandler<T, R>(){

    @Autowired
    internal lateinit var contactService: ContactService

    fun getContact(id: String): ContactEntity {
        val contact = contactService.getById(id)

        if (contact == null) {
            LOG.error("Contact with id $id not found.")
            throw ContactNotFoundException("Contact with id $id not found.")
        }

        LOG.info("Got contact with id $id (${contact.name} - ${contact.role}).")
        return contact
    }
}