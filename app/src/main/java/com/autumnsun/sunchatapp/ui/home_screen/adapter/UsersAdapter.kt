package com.autumnsun.sunchatapp.ui.home_screen.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.ui.home_screen.adapter.viewholder.UsersViewHolder

/*
 Created by Fatih Kurcenli on 12/22/2021
*/

class UsersAdapter(
    private val usersList: List<UsersModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UsersViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UsersViewHolder -> holder.bind(usersList[position])
        }
    }

    override fun getItemCount(): Int = usersList.size
}