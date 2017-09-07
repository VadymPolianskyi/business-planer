package com.exec.business.controller

import com.exec.business.handler.user.MyInformHandler
import com.exec.business.protocol.MyInformRequest
import com.exec.business.protocol.api.Response
import com.exec.business.protocol.api.RotingData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 10:01
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var myInformHandler: MyInformHandler

    @GetMapping
    fun myInform(): Response {
        return myInformHandler.handle(MyInformRequest(rotingData = RotingData("userId"))) //todo: correct rotingData support in filters
    }
}