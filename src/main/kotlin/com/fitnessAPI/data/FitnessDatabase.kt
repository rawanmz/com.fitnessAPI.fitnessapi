package com.fitnessAPI.data

import com.fitnessAPI.data.model.Exercise
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo


private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("FitnessDatabase")

private val exercises = database.getCollection<Exercise>()

suspend fun getExerciseFromId(id: String): Exercise? {
    return exercises.findOneById(id)
}

suspend fun createExerciseOrUpdateExercisesById(exercise: Exercise): Boolean {
    val exerciseExists = exercises.findOneById(exercise.id) != null
    return if (exerciseExists) {
        exercises.updateOneById(exercise.id, exercise).wasAcknowledged()
    } else {
        exercise.id = ObjectId().toString()
        exercises.insertOne(exercise).wasAcknowledged()
    }
}

suspend fun deleteExerciseFromId(exerciseId: String): Boolean {
    val exercise = exercises.findOne(Exercise::id eq exerciseId)
    exercise?.let { exercise ->
        return exercises.deleteOneById(exercise.id).wasAcknowledged()
    } ?: return false
}

suspend fun getAllExercises(): List<Exercise>? {
    return exercises.find().toList()
}