package ru.app.cheburechek.core.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

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

    abstract fun DB.initialize()
}