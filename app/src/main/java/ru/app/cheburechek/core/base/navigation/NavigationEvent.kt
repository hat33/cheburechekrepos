package ru.app.cheburechek.core.base.navigation

import androidx.navigation.NavDirections

sealed class NavigationEvent {
    data class Up(val directions: NavDirections) : NavigationEvent()
    object Back : NavigationEvent()
}