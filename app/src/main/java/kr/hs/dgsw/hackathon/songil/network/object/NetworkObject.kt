package kr.hs.dgsw.hackathon.songil.network.`object`

import kr.hs.dgsw.hackathon.songil.network.interceptor.TokenInterceptor
import kr.hs.dgsw.hackathon.songil.network.service.AuthService
import kr.hs.dgsw.hackathon.songil.network.service.PostService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkObject {
    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://15.165.88.215:8000/")
        .client(OkHttpClient.Builder().addInterceptor(TokenInterceptor()).build())
        .build()

    val postService = retrofit.create(PostService::class.java)
    val authService = retrofit.create(AuthService::class.java)
}