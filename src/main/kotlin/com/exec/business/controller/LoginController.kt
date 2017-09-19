package com.exec.business.controller

import com.exec.business.handler.factory.Factory
import com.exec.business.handler.login.LoginHandler
import com.exec.business.handler.login.RegisterHandler
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
    private lateinit var factory: Factory

    @PostMapping
    fun login(@RequestBody request: LoginRequest): Response {
        return factory.get(LoginHandler::class.java).handle(request)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): Response {
        return factory.get(RegisterHandler::class.java).handle(request)
    }

}