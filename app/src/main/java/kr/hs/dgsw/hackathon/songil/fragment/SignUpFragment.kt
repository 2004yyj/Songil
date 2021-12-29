package kr.hs.dgsw.hackathon.songil.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.activity.MainActivity
import kr.hs.dgsw.hackathon.songil.databinding.FragmentSignUpBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {
    private val binding by viewBindings(FragmentSignUpBinding::inflate)
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding.vm = viewModel
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        viewModelStore.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegisterSignUp.setOnClickListener {
            viewModel.executeSignUp().observe(viewLifecycleOwner) {
                Log.d("TAG", "onViewCreated: $it")
                findNavController().navigateUp()
                Toast.makeText(context, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getIsFailure().observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

}