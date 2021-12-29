package kr.hs.dgsw.hackathon.songil.entity.auth

data class SignUp(
    val id: String,
    val name: String,
    val password: String,
    val phone_number: String
)