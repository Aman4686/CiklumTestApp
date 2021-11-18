package com.example.ciklumtestapp.di

import android.util.Log
import com.example.ciklumtestapp.remote.TumblrApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class TumblrRetrofitModule {

    val TUMBLR_BASE_URL = "https://api.tumblr.com/v2/"

    @Provides
    fun provideTumblrHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()

            .addInterceptor { chain: Interceptor.Chain ->
                // I created api-key for myself and only after that I saw yours key in dock
                val token = "LZwVozQmKliXbC3xuuxNhLFmVm5dj5YUOu6m6VlGkXu4E9UrPO"
                var original = chain.request()
                val url = original.url().newBuilder().addQueryParameter("api_key", token).build()
                original = original.newBuilder().url(url).build()
                chain.proceed(original)
        }.build()
    }

    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(TUMBLR_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideTumblrApi(retrofit: Retrofit): TumblrApi {
        return retrofit.create(TumblrApi::class.java)
    }
}