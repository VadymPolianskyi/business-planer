package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.BusinessPlanDTO
import org.codehaus.jackson.annotate.JsonProperty
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:30.
 */
data class GetBusinessPlansRequest(
        override val rotingData: RotingData
): Request()

data class GetBusinessPlansResponse(
        @JsonProperty("business_plans")
        val businessPlans: List<BusinessPlanDTO>
): Response()

//create
data class CreateBusinessPlanRequest (
        override var rotingData: RotingData,
        @Valid
        @NotNull
        val businessPlan: BusinessPlanDTO
): Request()

class CreateBusinessPlanResponse : Response()

//update
data class UpdateBusinessPlanRequest (
        override val rotingData: RotingData,
        @Valid
        @NotNull
        val businessPlan: BusinessPlanDTO
): Request()

class UpdateBusinessPlanResponse : Response()

//delete
class DeleteBusinessPlanRequest(
        override val rotingData: RotingData?
) : Request()

class DeleteeBusinessPlanResponse : Response()

//read
data class GetBusinessPlanRequest (
        override val rotingData: RotingData,
        @Valid
        @NotNull
        @NotEmpty
        val planId: String
): Request()

data class GetBusinessPlanResponse(
        val businessPlan: BusinessPlanDTO
): Response()