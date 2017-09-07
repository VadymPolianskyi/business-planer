package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.UserDTO

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 9:51
 */

class MyInformRequest(
        override val rotingData: RotingData
) : Request()

data class MyInformResponse(
        val userDTO: UserDTO
) : Response()