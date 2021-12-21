package com.autumnsun.sunchatapp.ui.chat_screen

import com.airbnb.epoxy.EpoxyController
import com.autumnsun.sunchatapp.R
import com.autumnsun.sunchatapp.core.utils.ViewBindingKotlinModel
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.databinding.ModelReciverBinding
import com.autumnsun.sunchatapp.databinding.ModelSenderBinding
import java.util.*
import kotlin.collections.ArrayList

/*
 Created by Fatih Kurcenli on 12/21/2021
*/

class ChatEpoxyController : EpoxyController() {
    var isLoading: Boolean = false
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var chatModelList = ArrayList<ChatModel>()
        set(value) {
            field = value
            isLoading = false
            requestModelBuild()
        }

    override fun buildModels() {
        if (isLoading) {
            //todo
            return
        }

        if (chatModelList.isEmpty()) {
            // todo show empty stateD
            return
        }

        chatModelList.forEach { chatModel ->
            if (chatModel.isSender) {
                SenderMessageModel(chatModel.message).id(UUID.randomUUID().toString()).addTo(this)
            } else {
                ReceiverMessageModel(chatModel.message).id(UUID.randomUUID().toString()).addTo(this)
            }
        }
    }


    data class SenderMessageModel(
        val message: String
    ) : ViewBindingKotlinModel<ModelSenderBinding>(R.layout.model_sender) {
        override fun ModelSenderBinding.bind() {
            messageText.text = message
            dateNumber.text = "22:30"
        }
    }

    data class ReceiverMessageModel(
        val message: String
    ) : ViewBindingKotlinModel<ModelReciverBinding>(R.layout.model_reciver) {
        override fun ModelReciverBinding.bind() {
            messageText.text = message
            dateNumber.text = "22:20"
        }
    }
}