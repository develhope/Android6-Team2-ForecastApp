package co.develhope.meteoapp.today.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.ListTodayScreenBinding
import co.develhope.meteoapp.databinding.TitleTodayScreenBinding
import co.develhope.meteoapp.today.TodayData

class TodayAdapter(val todayList: List<TodayData>) : Adapter<ViewHolder>() {
    private val openedItems = mutableListOf<Int>()

    override fun getItemViewType(position: Int): Int {
        return todayList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TodayData.todayItem -> TodayViewHolder(
                ListTodayScreenBinding.inflate
                    (LayoutInflater.from(parent.context), parent, false)
            )

            TodayData.todayTitle -> TodayTitleViewHolder(
                TitleTodayScreenBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw Exception("Error: invalid ViewHolder")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = todayList[position]
        when (holder) {
            is TodayViewHolder -> holder.onBind(
                item as TodayData.TodayItem,
                position,
                openedItems
            ) {
                notifyItemChanged(position)
            }

            is TodayTitleViewHolder -> holder.onBind(item as TodayData.TodayTitle)
        }
    }

    override fun getItemCount(): Int {
        return todayList.size
    }


}