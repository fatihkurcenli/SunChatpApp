package com.autumnsun.sunchatapp.ui.chat_screen

import androidx.lifecycle.ViewModelProvider
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.BaseFragment
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.databinding.FragmentChatScreenBinding

/*
 Created by Fatih Kurcenli on 12/20/2021
*/

class ChatScreenFragment :
    BaseFragment<FragmentChatScreenBinding, ChatScreenViewModel>(R.layout.fragment_chat_screen) {

    private lateinit var chatScreenEpoxy: ChatEpoxyController
    private val list = ArrayList<ChatModel>()

    override fun initializeUi() {
        //mainActivity.bottomNavBar.visibility = View.GONE
        list.add(ChatModel("Selam", true, 123))
        list.add(ChatModel("merhaba", true, 123))
        list.add(ChatModel("Hello", false, 123))
        list.add(ChatModel("Hi", false, 123))
        chatScreenEpoxy = ChatEpoxyController()
        chatScreenEpoxy.chatModelList = list
        binding.messagesRecyclerView.setController(chatScreenEpoxy)
        chatScreenEpoxy.requestModelBuild()
    }

    override val mViewModel: ChatScreenViewModel
        get() = ViewModelProvider(requireActivity()).get(ChatScreenViewModel::class.java)

    override fun getViewBinding(): FragmentChatScreenBinding =
        FragmentChatScreenBinding.inflate(layoutInflater)

}