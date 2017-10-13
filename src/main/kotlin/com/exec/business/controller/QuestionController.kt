package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.handler.factory.Factory
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:03.
 */
@RestController
@RequestMapping("/login")
class QuestionController {
    @Autowired
    private lateinit var factory: Factory

    @GetMapping("/{id}")
    fun getBusinessPlan(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = GetBusinessPlanRequest(RotingData(credentials), id)
        return factory.get(GetBusinessPlanPlanHandler::class.java).handle(request)
    }
}
