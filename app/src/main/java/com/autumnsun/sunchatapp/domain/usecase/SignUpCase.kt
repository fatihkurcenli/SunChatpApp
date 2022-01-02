package com.autumnsun.sunchatapp.domain.usecase

import com.autumnsun.sunchatapp.core.utils.Resource
import com.autumnsun.sunchatapp.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

class SignUpCase(
    private val repository: ChatRepository
) {
    operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> {
        return flow {
            emit(Resource.Loading())
            try {
                repository.signUpUser(email, password)
            } catch (e: Exception) {
                e.message?.let {
                    emit(Resource.Error(it))
                }
            }
        }
    }
}