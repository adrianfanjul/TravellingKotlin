package com.tokioschool.travellingkotlin.presentation.features.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tokioschool.travellingkotlin.data.core.base.BaseViewModel
import com.tokioschool.travellingkotlin.domain.models.User
import com.tokioschool.travellingkotlin.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> get() = _user

    fun logIn(user: String, password: String) {
        viewModelScope.launch {
            loginRepository.logIn(user, password)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = it }
                .collect { user -> _user.value = user }
        }
    }
}