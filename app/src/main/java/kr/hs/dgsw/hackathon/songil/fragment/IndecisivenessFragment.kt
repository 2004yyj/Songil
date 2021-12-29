package kr.hs.dgsw.hackathon.songil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.dgsw.hackathon.songil.adapter.recyclerview.HomeViewAdapter
import kr.hs.dgsw.hackathon.songil.databinding.FragmentIndecisivenessBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kr.hs.dgsw.hackathon.songil.viewmodel.IndecisivenessViewModel

class IndecisivenessFragment : Fragment() {
    private val binding by viewBindings(FragmentIndecisivenessBinding::inflate)
    private val viewModel: IndecisivenessViewModel by viewModels()
    private lateinit var adapter: HomeViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        binding.rvIndecisiveness.scrollToPosition(0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = HomeViewAdapter()
        binding.rvIndecisiveness.adapter = adapter
        viewModel.getNewsList().observe(viewLifecycleOwner) {
            adapter.submitNewsList(it)
        }
        viewModel.getTalentDonationList().observe(viewLifecycleOwner) {
            adapter.submitDonationList(it.posts)
        }
    }

}