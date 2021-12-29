package kr.hs.dgsw.hackathon.songil.adapter.recyclerview

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.hackathon.songil.databinding.ItemNewsTabChildListBinding
import kr.hs.dgsw.hackathon.songil.entity.News

class NewsListAdapter(
    private val list: ArrayList<News>
): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemNewsTabChildListBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.btnTitleNewsItem.text = news.title
            binding.btnTitleNewsItem.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.link))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsTabChildListBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}