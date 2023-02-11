package ru.app.cheburechek.core.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.app.cheburechek.core.base.navigation.NavigationEvent
import ru.app.cheburechek.core.utils.observeNonNull

abstract class BaseFragment<DB : ViewDataBinding> constructor(
    @get:LayoutRes
    val layoutId: Int
) : Fragment() {

    abstract val viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<DB>(inflater, layoutId, container, false)

        binding.lifecycleOwner = this
        binding.initialize()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()
    }

    abstract fun DB.initialize()

    private fun observeNavigation() {
        viewModel.navigation.observeNonNull(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationEvent) {
        when (navCommand) {
            is NavigationEvent.Up -> findNavController().navigate(navCommand.directions)
            is NavigationEvent.Back -> findNavController().navigateUp()
        }
    }
}