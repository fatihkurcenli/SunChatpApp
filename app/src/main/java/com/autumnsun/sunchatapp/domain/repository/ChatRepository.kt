package com.autumnsun.sunchatapp.domain.repository

import com.autumnsun.sunchatapp.core.utils.Resource
import kotlinx.coroutines.flow.Flow

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

interface ChatRepository {
    fun signUpUser(email: String, password: String): Flow<Resource<Boolean>>
}