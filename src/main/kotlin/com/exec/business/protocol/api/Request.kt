package com.exec.business.protocol.api

import org.springframework.data.authentication.UserCredentials

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:22.
 */
abstract class Request {
    abstract val rotingData: RotingData?
}

data class RotingData(
        val credentials: UserCredentials?
)