package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.handler.business.GetBusinessesHandler
import com.exec.business.handler.factory.Factory
import com.exec.business.protocol.GetBusinessesRequest
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:28.
 */
@RestController
@RequestMapping("/business")
class BusinessController {
    @Autowired
    private lateinit var factory: Factory

    @GetMapping
    fun getBusiness(@AuthenticationPrincipal credentials: UserCredentials): Response {
        val request = GetBusinessesRequest(RotingData(credentials))
        return factory.get(GetBusinessesHandler::class.java).handle(request)
    }
}