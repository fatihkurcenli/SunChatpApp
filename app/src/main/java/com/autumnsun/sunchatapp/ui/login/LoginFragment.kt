package com.autumnsun.sunchatapp.ui.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.databinding.FragmentLoginBinding

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginViewModel>(
        R.layout.fragment_login
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override val mViewModel: LoginViewModel
        get() = ViewModelProvider(this)[LoginViewModel::class.java]

    override fun getViewBinding() = FragmentLoginBinding.inflate(layoutInflater)
}