package kr.hs.dgsw.hackathon.songil.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.databinding.FragmentCreatePostBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.CreatePostViewModel

class CreatePostFragment : Fragment() {
    private val binding by viewBindings(FragmentCreatePostBinding::inflate)
    private val viewModel: CreatePostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarCreatePost.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}