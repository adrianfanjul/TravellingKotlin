package com.tokioschool.travellingkotlin.data.datasource.impl

import com.tokioschool.travellingkotlin.data.api.ApiLogin
import com.tokioschool.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlin.data.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(
    private val apiLogin:ApiLogin
): LoginDatasource {
    override fun logIn(user:String,pass:String): Flow<UserResponse> = flow {
        emit(apiLogin.logInUser(mapOf("usuario" to user,"password" to pass)))
    }

    override fun registerUser() {
        //Not yet implemented
    }

    override fun logOut() {
        //Not yet implemented
    }
}