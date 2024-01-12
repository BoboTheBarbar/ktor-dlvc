package com.dlvc.plugins

import com.dlvc.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
    }
}
