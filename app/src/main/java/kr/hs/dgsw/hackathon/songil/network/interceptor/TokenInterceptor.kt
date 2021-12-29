package kr.hs.dgsw.hackathon.songil.network.interceptor

import kr.hs.dgsw.hackathon.songil.SharedPreference
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("Authorization", SharedPreference.token).build()
        return chain.proceed(request)
    }
}