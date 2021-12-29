package kr.hs.dgsw.hackathon.songil.entity.post

import kr.hs.dgsw.hackathon.songil.entity.user.User

data class PostElement(
    val post: Post,
    val user: User
)