package com.exec.business.protocol

import com.exec.business.protocol.api.Response

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:21.
 */
class LoginResponse(
        val token: String
) : Response()