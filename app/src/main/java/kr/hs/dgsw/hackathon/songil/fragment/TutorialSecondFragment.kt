package kr.hs.dgsw.hackathon.songil.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.activity.AuthActivity
import kr.hs.dgsw.hackathon.songil.activity.MainActivity
import kr.hs.dgsw.hackathon.songil.databinding.FragmentTutorialSecondBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings

class TutorialSecondFragment : Fragment() {

    private val binding by viewBindings(FragmentTutorialSecondBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(context, AuthActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

}