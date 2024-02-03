package com.dlvc.examples

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        orderRouting()
        totalizeOrderRoute()
    }
}
