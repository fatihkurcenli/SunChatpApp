package com.autumnsun.sunchatapp.ui.chat_screen.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.databinding.ModelReciverBinding

/*
 Created by Fatih Kurcenli on 12/21/2021
*/

class ReceiverViewHolder(
    private val receiverBinding: ModelReciverBinding
) : RecyclerView.ViewHolder(receiverBinding.root) {

    fun bind(chatModel: ChatModel) {
        receiverBinding.messageText.text = chatModel.message
        receiverBinding.dateNumber.text = "23:3233"
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): ReceiverViewHolder {
            val view = ModelReciverBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ReceiverViewHolder(view)
        }
    }
}
