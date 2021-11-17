package com.example.ciklumtestapp.di

import com.example.ciklumtestapp.remote.TumblrApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class TumblrRetrofitModule {

    @Provides
    fun provideTumblrHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("x-api-key", "4iocqfxd0huaaqmkt03cs2ya")
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        }.build()
    }

    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.tumblr.com/")
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