package ru.app.cheburechek.core.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import ru.app.cheburechek.core.base.navigation.Event
import ru.app.cheburechek.core.base.navigation.NavigationEvent

open class BaseViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<NavigationEvent>>()
    val navigation: LiveData<Event<NavigationEvent>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = Event(NavigationEvent.Up(navDirections))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationEvent.Back)
    }
}