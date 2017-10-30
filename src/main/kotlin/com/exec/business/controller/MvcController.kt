package com.exec.business.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Author: Vadym Polyanski
 * Date: 25.10.17
 * Time: 11:42
 */

@Controller
@RequestMapping("/business-planer")
class MvcController {

    @RequestMapping("/main")
    fun mainPage(): String {
        return "index"
    }

    @RequestMapping("/login")
    fun loginPage(): String {
        return "login"
    }
}
