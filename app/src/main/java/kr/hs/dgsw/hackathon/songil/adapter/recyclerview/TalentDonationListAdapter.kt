package kr.hs.dgsw.hackathon.songil.adapter.recyclerview

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ColorStateListDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.hackathon.songil.databinding.ItemTalentDonationTabChildListBinding
import kr.hs.dgsw.hackathon.songil.entity.post.PostElement
import kotlin.math.abs
import kotlin.random.Random

class TalentDonationListAdapter(
    private val list: List<PostElement>
): RecyclerView.Adapter<TalentDonationListAdapter.ViewHolder>() {

    private val colorCode = listOf(
        "#FFE999",
        "#FFD29D",
        "#FFACB6",
        "#C8E8FF",
        "#D6B7FF",
        "#C2F3BA"
    )

    inner class ViewHolder(
        private val binding: ItemTalentDonationTabChildListBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(postElement: PostElement) {
            val colorIndex = abs(Random(System.currentTimeMillis()).nextInt() % 6)
            binding.constraintBackgroundTalentDonationTabChildList.background = ColorDrawable(Color.parseColor(colorCode[colorIndex]))
            binding.tvTitleDonationItem.text = postElement.post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTalentDonationTabChildListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}