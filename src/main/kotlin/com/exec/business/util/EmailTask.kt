package com.exec.business.util

import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.entity.UserEntity
import java.io.Serializable


/**
 * Author: Vadym Polyanski;
 * Date: 22.10.17;
 * Time: 23:45.
 */
class EmailTask(private val emailService: EmailService, private val questionEntity: QuestionEntity,
                val user: UserEntity) : Runnable {


    override fun run() {
        if (user.email != null) {
            val data = DeadLineData(questionEntity.type.title,
                    questionEntity.answer, user.firstName, questionEntity.deadline!!)
            emailService.sendMessage(user.email!!, "dead-line", data)
        }
    }

   data class  DeadLineData(val question: String, val answer: String?, val user: String?, val time: Long) : Serializable

}