package com.dlvc.routes

import com.dlvc.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals


class CustomerRoutesKtTest {

    @Test
    fun customerRouting() =
        testApplication {
            application {
                configureRouting()
            }

            client.get("/customer").apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals("Empty", bodyAsText())
            }
        }
}