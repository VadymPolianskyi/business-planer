package com.exec.business.protocol

import com.exec.business.protocol.api.Request

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:21.
 */
class LoginRequest (
        var login: String,
        var password: String

): Request()