package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData

/**
 * Author: Valym Polyanski
 * Date: 07.09.17
 * Time: 9:42
 */
data class LoginRequest (
        val login: String,
        val password: String,
        override val rotingData: RotingData?
): Request()

data class LoginResponse(
        val token: String,
        val type: String,
        val expiresIn: Int,
        val refresh: String
) : Response()