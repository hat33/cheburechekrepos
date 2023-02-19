package ru.app.cheburechek.presentation.login

import androidx.fragment.app.viewModels
import ru.app.cheburechek.R
import ru.app.cheburechek.core.base.ui.BaseFragment
import ru.app.cheburechek.databinding.FragmentLoginBinding

class LoginFragment: BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModels()

    override fun FragmentLoginBinding.initialize() {
        this.vm = viewModel
    }
}