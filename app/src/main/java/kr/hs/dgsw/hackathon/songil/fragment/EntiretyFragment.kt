package kr.hs.dgsw.hackathon.songil.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.databinding.FragmentEntiretyBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.EntiretyViewModel

class EntiretyFragment : Fragment() {
    private val binding by viewBindings(FragmentEntiretyBinding::inflate)
    private val viewModel: EntiretyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

}