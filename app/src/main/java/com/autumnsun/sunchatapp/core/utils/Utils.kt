package com.autumnsun.sunchatapp.core.utils

/*
 Created by Fatih Kurcenli on 12/20/2021
*/

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}