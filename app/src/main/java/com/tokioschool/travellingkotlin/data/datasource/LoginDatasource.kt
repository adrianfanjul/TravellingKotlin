package com.tokioschool.travellingkotlin.data.datasource

import com.tokioschool.travellingkotlin.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun registerUser()
    fun logOut()
    fun logIn(user: String, pass: String): Flow<UserResponse>
}