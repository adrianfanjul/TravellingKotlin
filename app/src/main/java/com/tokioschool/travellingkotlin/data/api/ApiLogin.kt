package com.tokioschool.travellingkotlin.data.api

import com.tokioschool.travellingkotlin.data.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLogin {

    @POST("/login")
    suspend fun logInUser(
        @Body arguments: Map<String,String>
    ):UserResponse
}