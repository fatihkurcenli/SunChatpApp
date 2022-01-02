package com.autumnsun.sunchatapp.domain.repository

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

interface ChatRepository {
    suspend fun signUpUser(email: String, password: String): Boolean
}