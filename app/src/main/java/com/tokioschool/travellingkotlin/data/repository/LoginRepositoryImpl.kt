package com.tokioschool.travellingkotlin.data.repository

import com.tokioschool.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlin.data.mappers.mapToUser
import com.tokioschool.travellingkotlin.domain.models.User
import com.tokioschool.travellingkotlin.domain.repository.LoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource
) :LoginRepository {

    override fun logIn(userName: String, password: String): Flow<User> =
        loginDatasource.logIn(userName,password).map {it.mapToUser()}

    override suspend fun logInFaceBook(token:String):User {
        delay(5000)
        //Comprobamos el token y devolvemos elusuario
        return User("Luis","Perez",28)
    }
}