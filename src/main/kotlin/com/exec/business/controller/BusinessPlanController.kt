package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.handler.business.*
import com.exec.business.handler.factory.Factory
import com.exec.business.handler.business.CreateBusinessPlanHandler
import com.exec.business.handler.business.GetBusinessPlansHandler
import com.exec.business.protocol.*
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:28.
 */
@RestController
@RequestMapping("/business-plan")
class BusinessPlanController {
    @Autowired
    private lateinit var factory: Factory

    @GetMapping("/{id}")
    fun getBusinessPlan(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = GetBusinessPlanRequest(RotingData(credentials), id)
        return factory.get(GetBusinessPlanHandler::class.java).handle(request)
    }

    @GetMapping("/all")
    fun getAllBusinessPlans(@AuthenticationPrincipal credentials: UserCredentials): Response {
        val request = GetBusinessPlansRequest(RotingData(credentials))
        return factory.get(GetBusinessPlansHandler::class.java).handle(request)
    }

    @PostMapping
    fun createBusinessPlan(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: CreateBusinessPlanRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(CreateBusinessPlanHandler::class.java).handle(request)
    }

    @PutMapping
    fun updateBusinessPlan(
            @AuthenticationPrincipal credentials: UserCredentials,
            @RequestBody request: UpdateBusinessPlanRequest
    ): Response {
        request.rotingData = RotingData(credentials)
        return factory.get(UpdateBusinessPlanHandler::class.java).handle(request)
    }

    @DeleteMapping("/{id}")
    fun deleteBusinessPlan(
            @AuthenticationPrincipal credentials: UserCredentials,
            @PathVariable id: String
    ): Response {
        val request = DeleteBusinessPlanRequest(RotingData(credentials), id)
        return factory.get(DeleteBusinessPlanHandler::class.java).handle(request)
    }
}