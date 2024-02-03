package com.dlvc

import com.dlvc.examples.configureExampleRoutes
import com.dlvc.examples.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
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
            call.respond(ThymeleafContent("dealer", mapOf("item" to Item("Beer", 3.0, 0.5, "alcohol", "A drink"))))
        }
        post("/add") {
            val post = call.receiveText()
            call.respondText("Posted: $post")
        }

    }

    configureSerialization()
    configureExampleRoutes()
}

data class Item(
    val name: String,
    val price: Double,
    val weight: Double?,
    val tags: String,
    val description: String?
)
