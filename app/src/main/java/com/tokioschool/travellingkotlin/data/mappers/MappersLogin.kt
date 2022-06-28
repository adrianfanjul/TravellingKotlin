package com.tokioschool.travellingkotlin.data.mappers

import com.tokioschool.travellingkotlin.data.response.UserResponse
import com.tokioschool.travellingkotlin.domain.models.User

fun UserResponse.mapToUser() = User(
    name = this.name ?: "",
    surName = this.surName ?: "sin apellido",
    age = 23
)
