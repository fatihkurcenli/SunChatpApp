package com.autumnsun.sunchatapp.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpButton.setOnClickListener {
            mViewModel.signUpEmail(
                binding.emailAddressEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }


        lifecycleScope.launchWhenCreated {
            mViewModel.signUpState.collectLatest {
                if (it.isLoading) {
                    Log.d("SignUp", "isloading")
                } else {
                    Log.d("signup", "loadingstop")
                    Snackbar.make(binding.root, it.successMessage, Snackbar.LENGTH_LONG).show()
                }
            }

            mViewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is UIEvent.ShowSnackBar -> {
                        Snackbar.make(binding.root, event.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override val mViewModel: SignUpViewModel
        get() = ViewModelProvider(this)[SignUpViewModel::class.java]

    override fun getViewBinding() = FragmentSignUpBinding.inflate(layoutInflater)
}