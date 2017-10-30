package com.exec.business.controller

import com.exec.business.dao.entity.secure.UserCredentials
import com.exec.business.dao.entity.util.PlanStep
import com.exec.business.handler.business.GetBusinessPlansHandler
import com.exec.business.protocol.GetBusinessPlansRequest
import com.exec.business.protocol.api.RotingData
import com.exec.business.protocol.dto.BusinessPlanDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Author: Vadym Polyanski
 * Date: 25.10.17
 * Time: 11:42
 */

@Controller
@RequestMapping("/start")
class StartMvcController {

    @RequestMapping("/login")
    fun loginPage(): String {
        return "login"
    }

    @RequestMapping("/register")
    fun registerPage(): String {
        return "register"
    }

}