package com.dlvc

import com.dlvc.examples.models.Customer
import com.dlvc.examples.configureRouting
import com.dlvc.examples.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }

    routing {
        get("/dealer") {
            call.respond(ThymeleafContent("dealer", emptyMap()))
        }
    }

    routing {
        get("/index") {
            val sampleUser = Customer("1", "John", "Doe", "John.Doe@mail.com")
            call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
        }
    }

    routing {
        get("/store") {
            val sampleUser = Customer("1", "John", "Doe", "John.Doe@mail.com")
            call.respond(ThymeleafContent("storefront", mapOf("user" to sampleUser)))
        }
    }

    configureSerialization()
    configureRouting()
}
