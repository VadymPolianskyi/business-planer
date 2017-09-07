package com.exec.business.protocol.api

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:22.
 */
abstract class Request {
    abstract val rotingData: RotingData?
}

data class RotingData(
        val userId: String
)