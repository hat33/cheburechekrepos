package ru.app.cheburechek.presentation.signUp

import ru.app.cheburechek.core.base.ui.BaseViewModel

class SignUpViewModel : BaseViewModel() {

    fun onCloseClick() {
        navigateBack()
    }
}