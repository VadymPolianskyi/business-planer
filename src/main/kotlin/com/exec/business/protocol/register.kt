package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.UserDTO

/**
 * Author: val ym Polyanski
 * Date: 07.09.17
 * Time: 9:43
 */
data class RegisterRequest (
        val userDTO: UserDTO,
        val password: String,
        override val rotingData: RotingData?
) : Request()


data class RegisterResponse(
        val token: String,
        val type: String,
        val expiresIn: Int,
        val refresh: String
) : Response()