package co.develhope.meteoapp.home.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.home.WeekItems.HomeTitle

class TitleViewHolder(private val binding: HomeTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeTitle) {
        binding.homeTitle.text = item.locality
    }
}