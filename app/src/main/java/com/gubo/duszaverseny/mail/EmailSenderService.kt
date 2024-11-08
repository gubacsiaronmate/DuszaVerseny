package com.gubo.duszaverseny.mail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class EmailSenderService(private val to: String, private val subject: String, private val templateName: String, private val variables: Map<String, Any>) {
    suspend fun sendEmail() {
        withContext(Dispatchers.IO) {
            val templateEngine = TemplateEngine()
            val templateResolver = ClassLoaderTemplateResolver()
            templateResolver.suffix = ".html"
            templateResolver.prefix = "/templates/"
            templateResolver.characterEncoding = "UTF-8"
            templateResolver.templateMode = TemplateMode.HTML
            templateEngine.setTemplateResolver(templateResolver)

            val thymeleafContext = Context()
            thymeleafContext.setVariables(variables)

            val htmlBody = templateEngine.process(templateName, thymeleafContext)

            val properties = Properties()
            properties["mail.smtp.auth"] = "true"
            properties["mail.smtp.starttls.enable"] = "true"
            properties["mail.smtp.host"] = "smtp.gmail.com"
            properties["mail.smtp.port"] = 587
            properties["mail.debug"] = "true"
            properties["mail.username"] = "deb.devs.info@gmail.com"
            properties["mail.password"] = "uqgk musn kvaj aumd"

            val session = Session.getInstance(properties, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication("deb.devs.info@gmail.com", "uqgk musn kvaj aumd")
                }
            })

            try {
                val message = MimeMessage(session)
                message.setFrom("deb.devs.info@gmail.com")
                message.setRecipient(Message.RecipientType.TO, InternetAddress(to))
                message.subject = subject
                message.setContent(htmlBody, "text/html")

                println("from: ${message.from}\nto: ${message.allRecipients.joinToString(", ")}\nsubject: ${message.subject}\ncontent: ${message.content}")

                Transport.send(message)

                println("Email sent successfully")

            } catch (e: Exception) {
                println("Error sending email: $e")
            }
        }
    }
}