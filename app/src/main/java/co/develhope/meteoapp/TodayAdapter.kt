package co.develhope.meteoapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.ListTodayScreenBinding
import java.lang.Exception

class TodayAdapter(val todayList: List<TodayData>): Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return todayList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        return when(viewType){
            TodayData.todayItem -> TodayViewHolder(ListTodayScreenBinding.inflate
                (LayoutInflater.from(parent.context),parent,false))
            else -> throw Exception("Error: invalid ViewHolder")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = todayList[position]
        when (holder){
            is TodayViewHolder -> holder.onBind(item as TodayData.TodayItem)
        }
    }

    override fun getItemCount(): Int {
        return todayList.size
    }



}