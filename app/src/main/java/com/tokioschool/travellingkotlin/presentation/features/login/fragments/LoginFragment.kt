package com.tokioschool.travellingkotlin.presentation.features.login.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.tokioschool.travellingkotlin.R
import com.tokioschool.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschool.travellingkotlin.domain.models.User
import com.tokioschool.travellingkotlin.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import viewBinding

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()//Gestion de eventos
        observerViewModel()//observar el result data
    }

    private fun listeners() {
        binding.loginUserBtn.setOnClickListener { viewModel.logIn("jose", "123") }
        //binding.loginUserFacebookBtn.setOnClickListener{viewModel.logInFaceBook("tokenFacebook")}
    }

    private fun observerViewModel() {
        viewModel.user.observe(viewLifecycleOwner, ::stateUser)
        viewModel.loading.observe(viewLifecycleOwner, ::viewStateLoadings)
        viewModel.error.observe(viewLifecycleOwner, ::viewStateError)
    }

    private fun viewStateError(throwable: Throwable?) {
        Snackbar.make(binding.loginUserBtn, throwable?.message.toString(), Snackbar.LENGTH_LONG)
            .show()
    }

    private fun viewStateLoadings(loading: Boolean?) {
        loading?.let {
            //binding.animationView.showOrGone(it)
        }
    }

    private fun stateUser(user: User?) {
        user?.let {
            binding.loginResultUserTxt.text = it.name
        }
    }

}