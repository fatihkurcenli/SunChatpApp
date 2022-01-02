package com.autumnsun.sunchatapp.ui.signup

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

sealed class UIEvent {
    data class ShowSnackBar(val message: String) : UIEvent()
}
