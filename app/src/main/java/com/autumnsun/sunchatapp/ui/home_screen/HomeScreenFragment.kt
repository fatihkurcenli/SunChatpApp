package com.autumnsun.sunchatapp.ui.home_screen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.core.utils.SimpleDividerItemDecoration
import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.databinding.FragmentHomeScreenBinding
import com.autumnsun.sunchatapp.ui.home_screen.adapter.UsersAdapter

/*
 Created by Fatih Kurcenli on 12/22/2021
*/

class HomeScreenFragment :
    BaseFragment<FragmentHomeScreenBinding, HomeViewModel>(
        R.layout.fragment_home_screen
    ) {
    private lateinit var usersAdapter: UsersAdapter
    private val list = ArrayList<UsersModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dummyData()
        usersAdapter = UsersAdapter(list)
        //val itemDivider = DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL)
        val itemDivider = SimpleDividerItemDecoration(requireActivity())
        binding.chatUsersRecyclerview.apply {
            addItemDecoration(itemDivider)
            adapter = usersAdapter
        }

    }

    override val mViewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun getViewBinding(): FragmentHomeScreenBinding =
        FragmentHomeScreenBinding.inflate(layoutInflater)


    private fun dummyData() {
        list.add(
            UsersModel(
                "1",
                "Fatih Kurçenli",
                "https://avatars.githubusercontent.com/u/34714108?s=400&u=e2d04c7c9a2464fb1a7e9833760bf4f0ea334d26&v=4",
                123
            )
        )
        list.add(
            UsersModel(
                "1",
                "Fatih Kurçenli",
                "https://avatars.githubusercontent.com/u/34714108?s=400&u=e2d04c7c9a2464fb1a7e9833760bf4f0ea334d26&v=4",
                123
            )
        )
        list.add(
            UsersModel(
                "1",
                "Fatih Kurçenli",
                "https://avatars.githubusercontent.com/u/34714108?s=400&u=e2d04c7c9a2464fb1a7e9833760bf4f0ea334d26&v=4",

                123
            )
        )
        list.add(
            UsersModel(
                "1",
                "Fatih Kurçenli",
                "https://avatars.githubusercontent.com/u/34714108?s=400&u=e2d04c7c9a2464fb1a7e9833760bf4f0ea334d26&v=4",

                123
            )
        )
        list.add(
            UsersModel(
                "1",
                "Fatih Kurçenli",
                "https://avatars.githubusercontent.com/u/34714108?s=400&u=e2d04c7c9a2464fb1a7e9833760bf4f0ea334d26&v=4",

                123
            )
        )

    }
}