package kr.hs.dgsw.hackathon.songil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.hackathon.songil.entity.News
import kr.hs.dgsw.hackathon.songil.entity.postDTO.Post
import kr.hs.dgsw.hackathon.songil.entity.postDTO.PostElement
import kr.hs.dgsw.hackathon.songil.entity.postDTO.PostEntity
import kr.hs.dgsw.hackathon.songil.entity.user.User
import kr.hs.dgsw.hackathon.songil.network.`object`.NetworkObject

class IndecisivenessViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val postService = NetworkObject.postService

    private val _isFailure by lazy {
        MutableLiveData<String>()
    }

    private val _newsList by lazy {
        MutableLiveData<List<News>>(arrayListOf(
            News(
                "성인남녀 80% 결정장애 겪었다…배우자 고를 때도?",
                "https://www.chosun.com/site/data/html_dir/2017/11/27/2017112700597.html"
            ),
            News(
                "결정장애는 강박증? -핵심 감정은 '불안'",
                "http://www.psychiatricnews.net/news/articleView.html?idxno=2503"
            )
        ))
    }

    private val _talentDonationList by lazy {
        MutableLiveData<PostEntity>().apply {
            loadTalentDonationList()
        }
    }

    fun getIsFailure(): LiveData<String> {
        return _isFailure
    }

    fun getNewsList(): LiveData<List<News>> {
        return _newsList
    }

    fun getTalentDonationList(): LiveData<PostEntity> {
        return _talentDonationList
    }

    private fun loadTalentDonationList() {
        postService.getPosts("1")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _talentDonationList.value = it
            }, {
                _isFailure.value = it.message
            }).apply {
                compositeDisposable.add(this)
            }

    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}