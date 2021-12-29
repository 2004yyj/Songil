package kr.hs.dgsw.hackathon.songil.entity.post

data class Post(
    val category_id: Int,
    val content: String,
    val created_at: String,
    val detail: String,
    val id: Int,
    val icon: String,
    val title: String,
    val user_id: String
)