package kr.hs.dgsw.hackathon.songil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.hs.dgsw.hackathon.songil.entity.News
import kr.hs.dgsw.hackathon.songil.entity.post.Post
import kr.hs.dgsw.hackathon.songil.entity.post.PostElement
import kr.hs.dgsw.hackathon.songil.entity.post.PostEntity
import kr.hs.dgsw.hackathon.songil.entity.user.User

class IndecisivenessViewModel : ViewModel() {
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
        MutableLiveData(
            PostEntity("성공", arrayListOf(
                PostElement(Post(1, "응애", "2021", "디테일", 1, "","응애가 사람 잡는다던데", "23244"), User("asdf", "asdf", "asdf")),
                PostElement(Post(1, "응애", "2021", "디테일", 1, "","응애가 사람 잡는다던데", "23244"), User("asdf", "asdf", "asdf")),
                PostElement(Post(1, "응애", "2021", "디테일", 1, "","응애가 사람 잡는다던데", "23244"), User("asdf", "asdf", "asdf")),
                PostElement(Post(1, "응애", "2021", "디테일", 1, "","응애가 사람 잡는다던데", "23244"), User("asdf", "asdf", "asdf")),
                PostElement(Post(1, "응애", "2021", "디테일", 1, "","응애가 사람 잡는다던데", "23244"), User("asdf", "asdf", "asdf")),
            ))
        )
    }

    fun getNewsList(): LiveData<List<News>> {
        return _newsList
    }

    fun getTalentDonationList(): LiveData<PostEntity> {
        return _talentDonationList
    }
}