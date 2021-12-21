package com.autumnsun.sunchatapp.data.remote

/*
 Created by Fatih Kurcenli on 12/21/2021
*/

data class ChatModel(
    val message: String,
    val isSender: Boolean,
    val time: Long
)