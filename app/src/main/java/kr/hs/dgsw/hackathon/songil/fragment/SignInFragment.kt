package kr.hs.dgsw.hackathon.songil.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.SharedPreference
import kr.hs.dgsw.hackathon.songil.activity.MainActivity
import kr.hs.dgsw.hackathon.songil.databinding.FragmentSignInBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.SignInViewModel

class SignInFragment : Fragment() {
    private val binding by viewBindings(FragmentSignInBinding::inflate)
    private val viewModel: SignInViewModel by viewModels()

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

        binding.btnSignUpSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.btnLoginSignIn.setOnClickListener {
            viewModel.executeSignIn().observe(viewLifecycleOwner) {
                SharedPreference.token = it.token
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }

        viewModel.getIsFailure().observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

}