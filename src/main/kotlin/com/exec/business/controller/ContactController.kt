package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.handler.contact.*
import com.exec.business.handler.factory.Factory
import com.exec.business.protocol.*
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:03.
 */
@RestController
@RequestMapping("/contact")
class ContactController {
    @Autowired
    private lateinit var factory: Factory

    @GetMapping("/{id}")
    fun getContact(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = GetContactRequest(RotingData(credentials), id)
        return factory.get(GetContactHandler::class.java).handle(request)
    }

    @GetMapping("/all/{planId}")
    fun getContacts(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable planId: String
    ): Response {
        val request = GetContactsRequest(RotingData(credentials), planId)
        return factory.get(GetContactsHandler::class.java).handle(request)
    }

    @PutMapping
    fun updateContact(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: UpdateContactRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(UpdateContactHandler::class.java).handle(request)
    }

    @PostMapping
    fun createContact(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: CreateContactRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(CreateContactHandler::class.java).handle(request)
    }

    @DeleteMapping("/{id}")
    fun deleteContact(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = DeleteContactRequest(RotingData(credentials), id)

        return factory.get(DeleteContactHandler::class.java).handle(request)
    }
}