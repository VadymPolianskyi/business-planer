package com.exec.business.protocol.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:51.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Password is wrong..")
class WrongPasswordException(message: String) : RuntimeException(message) {

}