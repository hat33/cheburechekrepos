package ru.app.cheburechek.presentation.sign_up

import androidx.fragment.app.viewModels
import ru.app.cheburechek.R
import ru.app.cheburechek.core.base.ui.BaseFragment
import ru.app.cheburechek.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    override val viewModel: SignUpViewModel by viewModels()

    override fun FragmentSignUpBinding.initialize() {
        this.vm = viewModel
        this.fragmentSignupToolbar.setNavigationOnClickListener {
            viewModel.onCloseClick()
        }
    }
}