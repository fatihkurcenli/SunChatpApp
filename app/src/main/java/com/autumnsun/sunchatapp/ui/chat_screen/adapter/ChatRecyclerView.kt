package com.autumnsun.sunchatapp.ui.chat_screen.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sunchatapp.core.utils.MessageType
import com.autumnsun.sunchatapp.data.remote.ChatModel
import com.autumnsun.sunchatapp.ui.chat_screen.adapter.viewholder.ReceiverViewHolder
import com.autumnsun.sunchatapp.ui.chat_screen.adapter.viewholder.SenderViewHolder

/*
 Created by Fatih Kurcenli on 12/21/2021
*/


class ChatRecyclerView(
    val messageList: List<ChatModel>,
    val senderId: String,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int =
        if (messageList[position].senderId == senderId) {
            MessageType.SENDER.ordinal
        } else {
            MessageType.RECEIVER.ordinal
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MessageType.SENDER.ordinal -> SenderViewHolder.create(parent)
            MessageType.RECEIVER.ordinal -> ReceiverViewHolder.create(parent)
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SenderViewHolder -> holder.bind(messageList[position])
            is ReceiverViewHolder -> holder.bind(messageList[position])
            else -> throw Exception("Unknown view type exception")
        }
    }

    override fun getItemCount(): Int = messageList.size
}
