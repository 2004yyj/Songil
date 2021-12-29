package kr.hs.dgsw.hackathon.songil.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kr.hs.dgsw.hackathon.songil.R
import kr.hs.dgsw.hackathon.songil.adapter.viewpager.ViewPagerAdapter
import kr.hs.dgsw.hackathon.songil.databinding.FragmentHomeBinding
import kr.hs.dgsw.hackathon.songil.util.viewBindings
import kotlin.math.abs

class HomeFragment : Fragment() {
    private val binding by viewBindings(FragmentHomeBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appbarLayoutHome.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (abs(verticalOffset) < appBarLayout.totalScrollRange && abs(verticalOffset) > 0) {
                    ObjectAnimator
                        .ofFloat(
                            binding.toolbarHome,
                            "alpha",
                            0.0f
                        )
                        .start()
                }
                else if (abs(verticalOffset) >= appBarLayout.totalScrollRange) {
                    ObjectAnimator
                        .ofFloat(
                            binding.toolbarHome,
                            "alpha",
                            1.0f
                        )
                        .start()
                }
            }
        )

        binding.viewPagerHome.adapter = ViewPagerAdapter(this, arrayListOf(
            IndecisivenessFragment(),
            CrammingFragment(),
            PersuadeFragment(),
            EntiretyFragment()
        ))

        TabLayoutMediator(binding.tabLayoutHome, binding.viewPagerHome) { tab, position ->
            val array = resources.getStringArray(R.array.home_tab_array)
            tab.text = array[position]
        }.attach()

    }
}