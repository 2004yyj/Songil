package kr.hs.dgsw.hackathon.songil.network.`object`

import kr.hs.dgsw.hackathon.songil.network.service.PostService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkObject {
    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://15.165.88.215:8000/")
        .build()

    val postService = retrofit.create(PostService::class.java)
}