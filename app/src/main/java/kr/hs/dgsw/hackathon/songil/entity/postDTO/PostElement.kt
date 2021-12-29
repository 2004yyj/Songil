package kr.hs.dgsw.hackathon.songil.entity.postDTO

import kr.hs.dgsw.hackathon.songil.entity.user.User

data class PostElement(
    val post: Post,
    val user: User
)