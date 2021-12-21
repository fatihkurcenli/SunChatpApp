package com.autumnsun.sunchatapp.ui.chat_screen.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.databinding.ModelSenderBinding

/*
 Created by Fatih Kurcenli on 12/21/2021
*/

class SenderViewHolder(
    private val senderBinding: ModelSenderBinding
) : RecyclerView.ViewHolder(senderBinding.root) {

    fun bind(chatModel: ChatModel) {
        senderBinding.messageText.text = chatModel.message
        senderBinding.dateNumber.text = "23:32"
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): SenderViewHolder {
            val view = ModelSenderBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return SenderViewHolder(view)
        }
    }
}