package com.example.ciklumtestapp.features.imageList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ciklumtestapp.features.imageInfo.ImageInfoViewModel
import com.example.ciklumtestapp.navigation.MainNavigator
import com.example.ciklumtestapp.remote.TumblrRepository
import javax.inject.Inject

class ImageListViewModel constructor(
    val tumblrRepo: TumblrRepository
) : ViewModel() {

    class Factory @Inject constructor(
        private val tumblrRepo: TumblrRepository
    ): ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == ImageListViewModel::class.java)
            return ImageListViewModel(tumblrRepo) as T
        }
    }
}