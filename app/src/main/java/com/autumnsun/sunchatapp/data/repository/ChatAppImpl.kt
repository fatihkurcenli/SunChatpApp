package com.autumnsun.sunchatapp.data.repository

import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.domain.repository.ChatRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.database.FirebaseDatabase
import java.util.*

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class ChatAppImpl(
    private val api: FirebaseDatabase,
    private val auth: FirebaseAuth
) : ChatRepository {


    override suspend fun signUpUser(email: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val users = UsersModel(
                        auth.uid,
                        email,
                        "imageUrl",
                        "last message",
                        Calendar.getInstance().time.time
                    )
                    api.getReference("users").setValue(users).addOnFailureListener { dbException ->
                        throw dbException
                    }
                }
            }.addOnFailureListener { authException ->
                throw authException
            }
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            e.printStackTrace()
        }
    }
}