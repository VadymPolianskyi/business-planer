package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.hibernate.validator.constraints.NotEmpty
import org.jetbrains.annotations.NotNull
import javax.validation.Valid

/**
 * Author: Valym Polyanski
 * Date: 07.09.17
 * Time: 9:42
 */
data class LoginRequest (
        @Valid
        @NotEmpty
        @NotNull
        val login: String,
        @Valid
        @NotEmpty
        @NotNull
        val password: String,
        override val rotingData: RotingData?
): Request()

data class LoginResponse(
        val token: String,
        val type: String,
        val expiresIn: Int,
        val refresh: String
) : Response()