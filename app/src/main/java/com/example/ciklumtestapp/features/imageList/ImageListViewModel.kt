package com.example.ciklumtestapp.features.imageList

import TumbltResponsePOJO
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ciklumtestapp.base.BaseViewModel
import com.example.ciklumtestapp.remote.TumblrRepository
import javax.inject.Inject

class ImageListViewModel constructor(
    val tumblrRepo: TumblrRepository
) : BaseViewModel() {

    val tumblrResponseLiveData = MutableLiveData<TumbltResponsePOJO>()

    init {
        initImageListByDefault()
    }

    fun initImageListByTag(tag : String){
        val disposable = tumblrRepo.getTaggedByTag(tag)
            .subscribe({
                tumblrResponseLiveData.value = it
            },{
                Log.d("TestResult",  it.message.toString())
            })
        addDisposable(disposable)
    }

    fun initImageListByDefault(){
        val disposable = tumblrRepo.getTaggedByDefault()
            .subscribe({
                tumblrResponseLiveData.value = it
            },{
                Log.d("TestResult",  it.message.toString())
            })
        addDisposable(disposable)
    }

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