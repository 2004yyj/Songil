package kr.hs.dgsw.hackathon.songil.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.hackathon.songil.entity.auth.SignIn
import kr.hs.dgsw.hackathon.songil.entity.message.Message
import kr.hs.dgsw.hackathon.songil.entity.tokenDTO.Token
import kr.hs.dgsw.hackathon.songil.network.`object`.NetworkObject

class SignInViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val authService = NetworkObject.authService

    val id = ObservableField<String>()
    val pw = ObservableField<String>()

    private val _signIn by lazy {
        MutableLiveData<Token>().apply {
            signIn()
        }
    }

    private val _isFailure by lazy {
        MutableLiveData<String>()
    }

    fun executeSignIn(): LiveData<Token> {
        return _signIn
    }

    fun getIsFailure(): LiveData<String> {
        return _isFailure
    }

    private fun signIn() {
        val id = id.get() ?: ""
        val pw = pw.get() ?: ""
        authService.postSignIn(SignIn(id, pw))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (it.isSuccessful) {
                    _signIn.value = it.body()
                } else {
                    _isFailure.value = Gson().fromJson(it.errorBody()?.charStream(), Message::class.java).message
                }
            }, {
                _isFailure.value = it.message
            })
            .apply {
                compositeDisposable.add(this)
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}