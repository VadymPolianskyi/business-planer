package com.exec.business.protocol

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.dto.UserDTO

/**
 * Author: Vadym Polyanski;
 * Date: 07.09.17;
 * Time: 8:23.
 */
class RegisterRequest(
        var userDTO: UserDTO,
        var password: String
) : Request()