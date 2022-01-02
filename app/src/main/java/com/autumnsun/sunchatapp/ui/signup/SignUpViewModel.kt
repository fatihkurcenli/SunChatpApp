package com.autumnsun.sunchatapp.ui.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.autumnsun.sunchatapp.core.utils.Resource
import com.autumnsun.sunchatapp.domain.usecase.SunChatAppCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
 Created by Fatih Kurcenli on 1/2/2022
*/

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val sunChatAppCase: SunChatAppCase
) : ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState: StateFlow<SignUpState> = _signUpState

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun signUpEmail(email: String, password: String) {
        viewModelScope.launch {
            /*if (email.isEmpty() || password.isEmpty()) {
                _eventFlow.emit(UIEvent.ShowSnackBar("Boşluk bırakmayınız"))
                return@launch
            }
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _eventFlow.emit(UIEvent.ShowSnackBar("Geçerli bir e-mail adresi giriniz!"))
                return@launch
            }*/
            sunChatAppCase.signUpCase(email, password).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _signUpState.value = signUpState.value.copy(
                            successMessage = "Kayıt başarılı",
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _signUpState.value = signUpState.value.copy(isLoading = true)
                    }
                    is Resource.Error -> {
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            )
                        )
                    }
                }
            }.launchIn(this)
        }
    }

}