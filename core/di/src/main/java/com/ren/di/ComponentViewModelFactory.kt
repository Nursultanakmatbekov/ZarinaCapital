package com.ren.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ComponentViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = creator() as T
}