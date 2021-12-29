package kr.hs.dgsw.hackathon.songil.application

import android.app.Application
import kr.hs.dgsw.hackathon.songil.SharedPreference

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreference.init(this)
    }
}