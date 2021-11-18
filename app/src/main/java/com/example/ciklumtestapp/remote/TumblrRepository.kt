package com.example.ciklumtestapp.remote


import TumbltResponsePOJO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TumblrRepository(val tumblrApi: TumblrApi){

    fun getTaggedByTag(tag : String): Observable<TumbltResponsePOJO> {
        return tumblrApi.getTaggedByTag(tag)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getTaggedByDefault(): Observable<TumbltResponsePOJO> {
        return tumblrApi.getTaggedByTag("lol")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}