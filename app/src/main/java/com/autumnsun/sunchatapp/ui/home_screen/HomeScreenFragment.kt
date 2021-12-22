package com.autumnsun.sunchatapp.ui.home_screen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.databinding.FragmentHomeScreenBinding

/*
 Created by Fatih Kurcenli on 12/22/2021
*/

class HomeScreenFragment :
    BaseFragment<FragmentHomeScreenBinding, HomeViewModel>(
        R.layout.fragment_home_screen
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override val mViewModel: HomeViewModel
        get() = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun getViewBinding(): FragmentHomeScreenBinding =
        FragmentHomeScreenBinding.inflate(layoutInflater)
}