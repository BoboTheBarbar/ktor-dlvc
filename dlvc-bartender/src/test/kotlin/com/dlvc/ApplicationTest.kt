package com.dlvc

import com.dlvc.examples.configureRouting
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Assert
import kotlin.test.*

class ApplicationTest {
    @Ignore
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @org.junit.Test
    fun test() = testApplication {
        val response: String = client.get("/index").body()
        Assert.assertEquals(
            """
<html>
    <body>
        <h1>Hello, John</h1>
    </body>
</html>
        """.trimIndent(),
            response.replace("\r\n", "\n")
        )
    }

}
