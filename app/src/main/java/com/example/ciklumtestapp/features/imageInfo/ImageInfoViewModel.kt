package com.example.ciklumtestapp.features.imageInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ciklumtestapp.base.BaseViewModel
import com.example.ciklumtestapp.navigation.MainNavigator
import com.example.ciklumtestapp.remote.TumblrRepository
import javax.inject.Inject

class ImageInfoViewModel constructor(
    val tumblrRepo: TumblrRepository
    ) : BaseViewModel() {

    class Factory @Inject constructor(
        private val tumblrRepo: TumblrRepository
    ): ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == ImageInfoViewModel::class.java)
            return ImageInfoViewModel(tumblrRepo) as T
        }
    }
}