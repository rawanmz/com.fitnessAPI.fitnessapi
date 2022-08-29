package com.fitnessAPI.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Exercise(
    val name: String,
    val category: String,
    val description: String,
    val duration: String,
    val videoUrl: String,
    @BsonId
    var id: String = ObjectId().toString()
)
