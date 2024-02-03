package com.dlvc.examples

import com.dlvc.examples.models.Customer
import com.dlvc.examples.routes.customerRouting
import com.dlvc.examples.routes.orderRouting
import com.dlvc.examples.routes.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*

fun Application.configureExampleRoutes() {
    routing {

        get("/index") {
            val sampleUser = Customer("1", "John", "Doe", "John.Doe@mail.com")
            call.respond(ThymeleafContent("index", mapOf("user" to sampleUser)))
        }

        get("/store") {
            val sampleUser = Customer("1", "John", "Doe", "John.Doe@mail.com")
            call.respond(ThymeleafContent("storefront", mapOf("user" to sampleUser)))
        }

        customerRouting()
        orderRouting()
        totalizeOrderRoute()
    }
}
