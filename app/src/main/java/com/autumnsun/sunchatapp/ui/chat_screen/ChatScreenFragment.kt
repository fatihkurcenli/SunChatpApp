package com.autumnsun.sunchatapp.ui.chat_screen

import androidx.lifecycle.ViewModelProvider
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.databinding.FragmentChatScreenBinding
import com.autumnsun.sunchatapp.ui.chat_screen.adapter.ChatRecyclerView

/*
 Created by Fatih Kurcenli on 12/20/2021
*/

class ChatScreenFragment :
    BaseFragment<FragmentChatScreenBinding, ChatScreenViewModel>(R.layout.fragment_chat_screen) {

    private val list = ArrayList<ChatModel>()

    override fun initializeUi() {
        //mainActivity.bottomNavBar.visibility = View.GONE
        list.add(ChatModel("Selam", "123", 123))
        list.add(ChatModel("merhaba", "123", 123))
        list.add(ChatModel("Hello", "321", 123))
        list.add(ChatModel("Hi", "321", 123))
        val chatRecyclerView = ChatRecyclerView(list, "123")
        binding.messagesRecyclerView.adapter = chatRecyclerView

    }

    override val mViewModel: ChatScreenViewModel
        get() = ViewModelProvider(requireActivity()).get(ChatScreenViewModel::class.java)

    override fun getViewBinding(): FragmentChatScreenBinding =
        FragmentChatScreenBinding.inflate(layoutInflater)

}