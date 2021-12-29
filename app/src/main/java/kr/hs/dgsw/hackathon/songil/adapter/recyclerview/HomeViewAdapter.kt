package kr.hs.dgsw.hackathon.songil.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.hackathon.songil.databinding.ItemNewsTabBinding
import kr.hs.dgsw.hackathon.songil.databinding.ItemTalentDonationTabBinding
import kr.hs.dgsw.hackathon.songil.decorator.GridRecyclerViewDecorator
import kr.hs.dgsw.hackathon.songil.decorator.LinearRecyclerViewDecorator
import kr.hs.dgsw.hackathon.songil.entity.News
import kr.hs.dgsw.hackathon.songil.entity.postDTO.PostElement

class HomeViewAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val newsList = ArrayList<News>()
    private val donationList = ArrayList<PostElement>()

    fun submitNewsList(newList: List<News>) {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }

    fun submitDonationList(newList: List<PostElement>) {
        donationList.clear()
        donationList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(
        private val binding: ItemNewsTabBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.rvListNewsTab.adapter = NewsListAdapter(newsList)
            binding.rvListNewsTab.addItemDecoration(LinearRecyclerViewDecorator())
        }
    }

    inner class TalentDonationViewHolder(
        private val binding: ItemTalentDonationTabBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.rvListTalentDonationTab.adapter = TalentDonationListAdapter(donationList)
            binding.rvListTalentDonationTab.addItemDecoration(GridRecyclerViewDecorator())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_NEWS -> {
                val binding = ItemNewsTabBinding.inflate(LayoutInflater.from(parent.context))
                binding.root.layoutParams =
                    ViewGroup.LayoutParams(
                        MATCH_PARENT,
                        WRAP_CONTENT
                    )
                NewsViewHolder(binding)
            }
            VIEW_TYPE_DONATION -> {
                val binding = ItemTalentDonationTabBinding.inflate(LayoutInflater.from(parent.context))
                binding.root.layoutParams =
                    ViewGroup.LayoutParams(
                        MATCH_PARENT,
                        WRAP_CONTENT
                    )
                TalentDonationViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is NewsViewHolder -> {
                holder.bind()
            }
            is TalentDonationViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    companion object {
        private const val VIEW_TYPE_NEWS = 0
        private const val VIEW_TYPE_DONATION = 1

    }
}