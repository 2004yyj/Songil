package kr.hs.dgsw.hackathon.songil.entity.post

data class PostEntity(
    val massage: String,
    val posts: List<PostElement>
)