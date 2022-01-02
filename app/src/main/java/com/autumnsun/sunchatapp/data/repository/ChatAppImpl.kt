package com.autumnsun.sunchatapp.data.repository

import com.autumnsun.sunchatapp.core.utils.Resource
import com.autumnsun.sunchatapp.data.remote.UsersModel
import com.autumnsun.sunchatapp.domain.repository.ChatRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.*

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class ChatAppImpl(
    private val api: FirebaseDatabase,
    private val auth: FirebaseAuth
) : ChatRepository {

    override fun signUpUser(email: String, password: String): Flow<Resource<Boolean>> =
        flow {
            val getUser = auth.createUserWithEmailAndPassword(email, password).await()
            getUser.user?.let {
                val user = UsersModel(
                    id = it.uid,
                    "Fatih",
                    "imageUrl",
                    "ok",
                    Calendar.getInstance().timeInMillis
                )
                api.getReference("users").child("data").setValue(user).await()
                emit(Resource.Success(data = true))
            } ?: emit(Resource.Error("Kayıt edilemedi"))
        }
}