package com.dlvc.plugins

import com.dlvc.routes.customerRouting
import com.dlvc.routes.orderRouting
import com.dlvc.routes.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        orderRouting()
        totalizeOrderRoute()
    }
}
