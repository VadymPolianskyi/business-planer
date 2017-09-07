package com.exec.business.controller

import com.exec.business.handler.LoginHandler
import com.exec.business.handler.RegisterHandler
import com.exec.business.protocol.LoginRequest
import com.exec.business.protocol.RegisterRequest
import com.exec.business.protocol.api.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:15.
 */
@RestController
@RequestMapping("/login")
class LoginController {

    @Autowired
    private lateinit var loginHandler: LoginHandler
    @Autowired
    private lateinit var registerHandler: RegisterHandler

    @PostMapping
    fun login(@RequestBody request: LoginRequest): Response {
        return loginHandler.handle(request)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): Response {
        return registerHandler.handle(request)
    }

}