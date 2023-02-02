package ru.app.cheburechek

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun onClick() {

        Toast.makeText(getApplication(), "${login.value} ${password.value}", Toast.LENGTH_LONG).show()
    }
}