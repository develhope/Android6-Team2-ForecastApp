package co.develhope.meteoapp.today

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.SubtitleTodayScreenBinding

class TodayTitleViewHolder(private val binding: SubtitleTodayScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: TodayData.TodayTitle){
        binding.todayLocationTv.text = item.todayLocation
        binding.todaySubtitleShortTv.text = item.todayDay
        binding.todaySubtitleLongTv.text = item.todayDate
    }
}