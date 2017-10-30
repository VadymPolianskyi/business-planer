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
@RequestMapping("/business-planer")
class MvcController {

    @Autowired
    private lateinit var getBusinessPlansHandler: GetBusinessPlansHandler

    @RequestMapping("/main")
    fun mainPage(model: Model, @AuthenticationPrincipal credentials: UserCredentials): String {
        val planSteps = PlanStep.values()
        val plans: List<BusinessPlanDTO> = getBusinessPlansHandler.handle(GetBusinessPlansRequest(RotingData(credentials))).businessPlans


        plans.map{plan -> {
            if (plan.description!!.length > 100)
                plan.description = plan.description!!.substring(0, 100)
            }
        }

        model.addAttribute("businessPlans", plans)
        model.addAttribute("planSteps", planSteps)

        return "index"
    }

    @RequestMapping("/login")
    fun loginPage(): String {
        return "login"
    }

    @RequestMapping("/register")
    fun registerPage(): String {
        return "register"
    }

    @RequestMapping("/business")
    fun businessPage(): String {
        return "business"
    }
}
