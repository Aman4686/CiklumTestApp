package com.example.ciklumtestapp.di

import com.example.ciklumtestapp.remote.TumblrRepository
import dagger.Module
import dagger.Provides

@Module
class TumblrRepositoryModule {

    @Provides
    fun provideTumblrRepository() : TumblrRepository{
        return TumblrRepository()
    }


}