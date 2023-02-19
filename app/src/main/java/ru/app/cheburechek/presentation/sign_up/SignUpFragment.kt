package ru.app.cheburechek.presentation.sign_up

import androidx.fragment.app.viewModels
import ru.app.cheburechek.R
import ru.app.cheburechek.core.base.ui.BaseFragment
import ru.app.cheburechek.databinding.FragmentSignupBinding

class SignUpFragment : BaseFragment<FragmentSignupBinding>(R.layout.fragment_signup) {

    override val viewModel: SignUpViewModel by viewModels()

    override fun FragmentSignupBinding.initialize() {
        this.vm = viewModel
        this.fragmentSignupToolbar.setNavigationOnClickListener {
            viewModel.onCloseClick()
        }
    }
}