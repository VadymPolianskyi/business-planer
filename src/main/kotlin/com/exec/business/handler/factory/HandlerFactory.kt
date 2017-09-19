package com.exec.business.handler.factory

import com.exec.business.handler.api.Handler
import com.exec.business.protocol.api.Request
import com.exec.business.protocol.api.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.aop.framework.AopProxyUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct


/**
 * Author: Vadym Polyanski;
 * Date: 19.09.17;
 * Time: 22:22.
 */
@Component
open class HandlerFactory: Factory {

    @Autowired
    lateinit var handlers : List<Handler<*,*>>

    private val LOG: Logger = LoggerFactory.getLogger(this.javaClass.name)
    private var handlersMap = HashMap<Class<*>, Handler<Request,Response>>()

    @Suppress("UNCHECKED_CAST")
    @PostConstruct
    fun init() {
        for (handler in handlers) {
            val key: Class<*> = AopProxyUtils.ultimateTargetClass(handler)
            LOG.info("Created new handler {}", key.name)
            this.handlersMap.put(key, handler as Handler<Request, Response>)
        }
    }

    override fun get(key: Class<*>): Handler<Request,Response> {
        LOG.info("Got handler {}", key.name)
        return handlersMap[key]!!
    }
}