package kr.hs.dgsw.hackathon.songil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.dgsw.hackathon.songil.databinding.FragmentCrammingBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.CrammingViewModel

class CrammingFragment : Fragment() {
    private val binding by viewBindings(FragmentCrammingBinding::inflate)
    private val viewModel: CrammingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }
}