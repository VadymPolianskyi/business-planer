package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.BusinessDTO

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 8:30.
 */
data class GetBusinessesRequest (
        override val rotingData: RotingData?
): Request()

data class GetBusinessesResponse (
        val businesses: List<BusinessDTO>
): Response()