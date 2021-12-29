package kr.hs.dgsw.hackathon.songil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.dgsw.hackathon.songil.adapter.recyclerview.HomeViewAdapter
import kr.hs.dgsw.hackathon.songil.databinding.FragmentCrammingBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.CrammingViewModel

class CrammingFragment : Fragment() {
    private val binding by viewBindings(FragmentCrammingBinding::inflate)
    private val viewModel: CrammingViewModel by viewModels()
    private lateinit var adapter: HomeViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        binding.rvCramming.scrollToPosition(0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = HomeViewAdapter()
        binding.rvCramming.adapter = adapter
        viewModel.getNewsList().observe(viewLifecycleOwner) {
            adapter.submitNewsList(it)
        }
        viewModel.getTalentDonationList().observe(viewLifecycleOwner) {
            it.posts?.let { posts -> adapter.submitDonationList(posts) }
        }
        viewModel.getIsFailure().observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}