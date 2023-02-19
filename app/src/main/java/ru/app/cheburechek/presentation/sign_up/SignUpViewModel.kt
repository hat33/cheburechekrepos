package ru.app.cheburechek.presentation.sign_up

import ru.app.cheburechek.core.base.ui.BaseViewModel

class SignUpViewModel : BaseViewModel() {

    fun onCloseClick() {
        navigateBack()
    }
}