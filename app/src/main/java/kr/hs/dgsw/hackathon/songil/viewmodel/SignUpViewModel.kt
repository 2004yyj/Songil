package kr.hs.dgsw.hackathon.songil.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.hackathon.songil.entity.auth.SignUp
import kr.hs.dgsw.hackathon.songil.entity.message.Message
import kr.hs.dgsw.hackathon.songil.network.`object`.NetworkObject

class SignUpViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val authService = NetworkObject.authService

    val id = ObservableField<String>()
    val pw = ObservableField<String>()
    val name = ObservableField<String>()
    val phoneNumber = ObservableField<String>()

    private val _signUp by lazy {
        MutableLiveData<String>().apply {
            signUp()
        }
    }

    private val _isFailure by lazy {
        MutableLiveData<String>()
    }

    fun getIsFailure(): LiveData<String> {
        return _isFailure
    }

    fun executeSignUp(): LiveData<String> {
        return _signUp
    }

    private fun signUp() {
        val id = id.get() ?: ""
        val pw = pw.get() ?: ""
        val name = name.get() ?: ""
        val phoneNumber = phoneNumber.get() ?: ""

        authService.postSignUp(SignUp(id, name, pw, phoneNumber))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (it.isSuccessful) {
                    _signUp.value = "성공"
                } else {
                    _isFailure.value = Gson().fromJson(it.errorBody()?.charStream(), Message::class.java).message
                }
            }, {
                it.printStackTrace()
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