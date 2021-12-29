package kr.hs.dgsw.hackathon.songil.network.service

import io.reactivex.Single
import kr.hs.dgsw.hackathon.songil.entity.message.Message
import kr.hs.dgsw.hackathon.songil.entity.postBody.PostBody
import kr.hs.dgsw.hackathon.songil.entity.postDTO.PostElement
import kr.hs.dgsw.hackathon.songil.entity.postDTO.PostEntity
import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @GET("/post")
    fun getPosts(@Query("cartgory") category: String?): Single<Response<PostEntity>>

    @POST("/post")
    fun postPosts(@Body postBody: PostBody): Single<Response<Message>>

    @GET("/post/{postId}")
    fun getPostById(@Path("postId") postId: Int): Single<Response<PostElement>>
}