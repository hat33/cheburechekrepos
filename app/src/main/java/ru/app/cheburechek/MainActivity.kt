package ru.app.cheburechek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.app.cheburechek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}