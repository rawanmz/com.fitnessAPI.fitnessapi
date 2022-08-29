package com.fitnessAPI.routes

import com.fitnessAPI.data.createExerciseOrUpdateExercisesById
import com.fitnessAPI.data.deleteExerciseFromId
import com.fitnessAPI.data.getAllExercises
import com.fitnessAPI.data.getExerciseFromId
import com.fitnessAPI.data.model.Exercise
import com.fitnessAPI.data.request.FitnessRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.fitnessRoutes() {
    route("/get-exercise") {
        get {
            val exerciseId = call.request.queryParameters["id"].toString()?:""
            //val exerciseId = call.receive<FitnessRequest>().id
            val exercise = getExerciseFromId(exerciseId)
            exercise?.let {
                call.respond(
                    HttpStatusCode.OK, it
                )
            } ?: call.respond(
                HttpStatusCode.OK, "There is no exercise with this id"
            )
        }
    }
    route("/get-exercises") {
        get {
            val exercises = getAllExercises()
            exercises?.let {
                call.respond(
                    HttpStatusCode.OK, it
                )
            } ?: call.respond(
                HttpStatusCode.OK, "There is no exercises "
            )
        }
    }
    route("/create-update-exercise") {
        post {
            val request = try {
                call.receive<Exercise>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (createExerciseOrUpdateExercisesById(request)) {
                call.respond(
                    HttpStatusCode.OK, "Exercise successfully created/ updated"

                )
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }

    route("/delete-exercise") {
        post {
            val request = try {
                call.receive<FitnessRequest>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (deleteExerciseFromId(request.id)) {
                call.respond(
                    HttpStatusCode.OK, "Exercise successfully deleted"
                )
            } else {
                call.respond(
                    HttpStatusCode.OK, "Exercise not found"
                )
            }
        }
    }
}
