package com.exec.business.controller

import com.exec.business.handler.LoginHandler
import com.exec.business.protocol.LoginRequest
import com.exec.business.protocol.api.Response
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
class LoginController(
        private val loginHandler: LoginHandler
) {

    @PostMapping
    fun login(@RequestBody request: LoginRequest): Response {
        return loginHandler.handle(request)
    }

}