package com.example.ciklumtestapp.remote


import TumbltResponsePOJO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TumblrApi {

    @GET("tagged/")
    fun getTaggedByTag(@Query("tag") tag : String) : Observable<TumbltResponsePOJO>

}