package ru.app.cheburechek.presentation.start

import ru.app.cheburechek.core.base.ui.BaseViewModel

class StartViewModel: BaseViewModel() {

    fun onLoginClick() {
        navigate(
            StartFragmentDirections.actionToLoginFragment()
        )
    }
}