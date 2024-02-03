package com.dlvc.examples

import com.dlvc.examples.routes.customerRouting
import com.dlvc.examples.routes.orderRouting
import com.dlvc.examples.routes.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        orderRouting()
        totalizeOrderRoute()
    }
}
