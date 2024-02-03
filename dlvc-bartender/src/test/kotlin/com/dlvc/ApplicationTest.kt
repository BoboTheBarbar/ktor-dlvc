package com.dlvc

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.server.testing.*
import org.junit.Assert

class ApplicationTest {

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
