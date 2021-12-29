package kr.hs.dgsw.hackathon.songil.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.databinding.FragmentTutorialFirstBinding
import kr.hs.dgsw.hackathon.songil.databinding.FragmentTutorialSecondBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings

class TutorialFirstFragment : Fragment() {

    private val binding by viewBindings(FragmentTutorialFirstBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tutorialFirstFragment_to_tutorialSecondFragment)
        }
    }

}