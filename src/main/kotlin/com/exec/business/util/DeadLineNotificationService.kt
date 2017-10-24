package com.exec.business.util

import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.entity.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Author: Vadym Polyanski;
 * Date: 22.10.17;
 * Time: 13:55.
 */
@Component
open class DeadLineNotificationService {

    private val executor: ScheduledThreadPoolExecutor = ScheduledThreadPoolExecutor(4)

    @Autowired
    private lateinit var emailService: EmailService

    fun addBusinessTask(question:QuestionEntity, deadLine: Long, user: UserEntity) {

        val task: EmailTask = EmailTask(emailService, question, user)

        executor.schedule(task, deadLine, TimeUnit.SECONDS)
    }
}