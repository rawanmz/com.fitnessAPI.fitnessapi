package com.fitnessAPI

import io.ktor.server.application.*
import com.fitnessAPI.plugins.*


//fun main(args: Array<String>) {
//    embeddedServer(Netty, port = getFreePort()) {
//        routing {
//            fitnessRoutes()
//            get("/") {
//                call.respondText("Hello World!")
//            }
//        }
//    }.start()
//}
//
//fun getFreePort(): Int {
//    val socket = ServerSocket(0)
//    val port = socket.localPort
//    socket.close()
//    return port
//}


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureSerialization()
}
