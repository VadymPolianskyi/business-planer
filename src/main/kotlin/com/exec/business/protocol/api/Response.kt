package com.exec.business.protocol.api

import org.springframework.http.HttpStatus

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:22.
 */
abstract class Response(
        val code: Int = HttpStatus.OK.value(),
        val message: String = HttpStatus.OK.reasonPhrase
)