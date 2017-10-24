package com.exec.business.util

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.exec.business.dao.entity.QuestionEntity
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils
import org.springframework.beans.factory.annotation.Autowired
import java.io.IOException
import javax.mail.MessagingException

/**
 * Author: Vadym Polyanski;
 * Date: 22.10.17;
 * Time: 13:53.
 */
@Component
open class EmailService {


    @Autowired
    lateinit var  javaMailSender: JavaMailSender
    @Autowired
    lateinit var  freemarkerConfig: Configuration


    open fun sendMessage(address: String, templateName: String, model: Any) {
        try {
            val message = javaMailSender.createMimeMessage()

            val helper = MimeMessageHelper(message)

            freemarkerConfig.setClassForTemplateLoading(this.javaClass, "/templates/email")
            val t = freemarkerConfig.getTemplate(templateName + ".ftl")
            val text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model)

            helper.setTo(address)
            message.setHeader("Content-Type", "text/plain; charset=UTF-8")
            message.setText(text, "UTF-8", "html")
            helper.setSubject("Business-Planer Application")

            javaMailSender.send(message)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: TemplateException) {
            e.printStackTrace()
        } catch (e: MessagingException) {
            e.printStackTrace()
        }

    }
}