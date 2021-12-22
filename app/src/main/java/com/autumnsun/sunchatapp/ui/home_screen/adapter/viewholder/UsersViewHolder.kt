package com.autumnsun.sunchatapp.ui.home_screen.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.databinding.ModelUsersChatBinding

/*
 Created by Fatih Kurcenli on 12/22/2021
*/

class UsersViewHolder(
    private val usersChatBinding: ModelUsersChatBinding
) : RecyclerView.ViewHolder(usersChatBinding.root) {


    fun bind(usersChatModel: UsersModel) {
        usersChatBinding.chatUserModel = usersChatModel
        usersChatBinding.date = usersChatModel.date.toString()
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): UsersViewHolder {
            val view =
                ModelUsersChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UsersViewHolder(view)
        }
    }
}