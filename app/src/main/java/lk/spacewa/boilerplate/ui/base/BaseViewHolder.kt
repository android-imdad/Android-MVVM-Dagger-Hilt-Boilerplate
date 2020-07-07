package lk.spacewa.boilerplate.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Imdad on 05/11/20.
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    abstract fun onBind(position: Int)
}