package kr.hs.dgsw.hackathon.songil.network.service

import io.reactivex.Single
import kr.hs.dgsw.hackathon.songil.entity.auth.SignIn
import kr.hs.dgsw.hackathon.songil.entity.auth.SignUp
import kr.hs.dgsw.hackathon.songil.entity.message.Message
import kr.hs.dgsw.hackathon.songil.entity.tokenDTO.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("user/sign_in")
    fun postSignIn(
        @Body signIn: SignIn
    ): Single<Response<Token>>

    @POST("user/sign_up")
    fun postSignUp(
        @Body signUp: SignUp
    ): Single<Response<Message>>
}