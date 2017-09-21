package com.exec.business.handler.business

import com.exec.business.handler.api.LogHandler
import com.exec.business.protocol.GetBusinessesRequest
import com.exec.business.protocol.GetBusinessesResponse
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:37.
 */
@Component
open class GetBusinessesHandler : LogHandler<GetBusinessesRequest, GetBusinessesResponse>() {

    override fun handle(request: GetBusinessesRequest): GetBusinessesResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}