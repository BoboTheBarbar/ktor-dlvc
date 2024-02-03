package com.dlvc.routes

import com.dlvc.examples.configureRouting
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotHaveLength
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test


class OrderRoutesKtTest {

    @Test
    fun orderRouting() {
        testApplication {
            application {
                configureRouting()
            }
            client.get("/order").apply {
                status shouldBe HttpStatusCode.OK
                bodyAsText() shouldNotHaveLength 0
            }
        }
    }

    @Test
    fun totalizeOrderRoute() {
    }
}