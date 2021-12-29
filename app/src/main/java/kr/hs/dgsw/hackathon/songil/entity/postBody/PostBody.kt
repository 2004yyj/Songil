package kr.hs.dgsw.hackathon.songil.entity.postBody

data class PostBody(
    val category_id: Int,
    val content: String,
    val detail: String,
    val title: String
)