package com.exec.business.handler.question

import com.exec.business.dao.entity.util.PlanStep
import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.AllTypesRequest
import com.exec.business.protocol.AllTypesResponse
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
open class AllTypesHandler : LogHandler<AllTypesRequest, AllTypesResponse>() {
    override fun handle(request: AllTypesRequest): AllTypesResponse {
        val types = PlanStep.values()
                .asList().stream()
                .map { it.title }
                .toList()
        return AllTypesResponse( types)

    }

}
