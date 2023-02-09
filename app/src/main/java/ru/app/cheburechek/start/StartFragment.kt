package ru.app.cheburechek.start

import androidx.fragment.app.viewModels
import ru.app.cheburechek.R
import ru.app.cheburechek.core.base.ui.BaseFragment
import ru.app.cheburechek.databinding.FragmentStartBinding

internal class StartFragment :
    BaseFragment<FragmentStartBinding>(layoutId = R.layout.fragment_start) {

    override val viewModel: StartViewModel by viewModels()

    override fun FragmentStartBinding.initialize() {
        this.vm = viewModel
    }
}