package com.example.ciklumtestapp.di

import com.example.ciklumtestapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [TumblrRepositoryModule::class , TumblrRetrofitModule::class])
abstract class AppModule()

