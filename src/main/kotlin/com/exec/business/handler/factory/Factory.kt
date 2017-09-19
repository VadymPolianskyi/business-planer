package com.exec.business.handler.factory

import com.exec.business.handler.api.Handler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response


/**
 * Author: Vadym Polyanski;
 * Date: 19.09.17;
 * Time: 22:18.
 */
interface Factory{
    fun get(key: Class<*>): Handler<Request, Response>
}