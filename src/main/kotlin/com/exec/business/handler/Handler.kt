package com.exec.business.handler

import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:33.
 */
interface Handler<in T : Request, out R : Response> {

    fun handle(request: T): R

}