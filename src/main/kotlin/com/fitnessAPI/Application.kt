package com.fitnessAPI

import io.ktor.server.application.*
import com.fitnessAPI.plugins.*
import com.fitnessAPI.routes.fitnessRoutes
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.net.ServerSocket


fun main(args: Array<String>) {
    embeddedServer(Netty, port = getFreePort()) {
        routing {
            fitnessRoutes()
            get("/") {
                call.respondText("Hello World!")
            }
        }
    }.start()
}

fun getFreePort(): Int {
    val socket = ServerSocket(0)
    val port = socket.localPort
    socket.close()
    return port
}
//fun main(args: Array<String>): Unit =
//    io.ktor.server.netty.EngineMain.main(args)
//
//@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
//fun Application.module() {
//    configureSerialization()
//    configureRouting()
//}
