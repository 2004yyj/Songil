package kr.hs.dgsw.hackathon.songil.decorator

import android.graphics.Rect
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView

class LinearRecyclerViewDecorator: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildLayoutPosition(view) < state.itemCount) {
                bottom = 25
            }
        }
    }
}