package com.fitnessAPI.plugins

import com.fitnessAPI.routes.fitnessRoutes
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        fitnessRoutes()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
