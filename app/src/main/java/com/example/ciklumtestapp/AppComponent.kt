package com.example.ciklumtestapp

import android.content.Context
import com.example.ciklumtestapp.di.AppModule
import com.example.ciklumtestapp.features.imageInfo.ImageInfoFragment
import com.example.ciklumtestapp.features.imageList.ImageListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(imageInfoFragment: ImageInfoFragment)
    fun inject(imageListFragment: ImageListFragment)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun appContext(appContext: Context): Builder

        fun build(): AppComponent

    }

}