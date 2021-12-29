package kr.hs.dgsw.hackathon.songil.entity.postDTO

data class PostEntity(
    val massage: String,
    val posts: List<PostElement>?
)