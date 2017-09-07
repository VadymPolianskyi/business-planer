package com.exec.business.handler.api

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 10:28
 */

abstract class LogHandler<in T : Request, out R : Response> : Handler<T, R> {

    val LOG: Logger = LoggerFactory.getLogger(this.javaClass.name)

}