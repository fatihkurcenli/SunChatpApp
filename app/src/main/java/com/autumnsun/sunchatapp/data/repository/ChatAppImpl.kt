package com.autumnsun.sunchatapp.data.repository

import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.domain.repository.ChatRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class ChatAppImpl(
    private val api: FirebaseDatabase,
    private val auth: FirebaseAuth
) : ChatRepository {
    override suspend fun signUpUser(email: String, password: String): Boolean {
        var isSuccess = false
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val users = UsersModel(id = auth.uid, email, "", "", 123)
                api.getReference("users").setValue(users).addOnCompleteListener {
                    isSuccess = task.isSuccessful
                }
            } else {
                isSuccess = false
            }
        }
        return isSuccess
    }
}