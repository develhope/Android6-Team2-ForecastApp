package co.develhope.meteoapp.home.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.home.setWeatherIcon

class TodayViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Today, onClick: (WeekItems) -> Unit) {
        binding.textDayOfWeekList.text = "OGGI"
        binding.textDayOfMonthList.text = item.date.toString()
        binding.textMinNumList.text = item.minTemperature.toString()
        binding.textMaxNumList.text = item.maxTemperature.toString()
        binding.imgSkyList.setWeatherIcon(item.weatherIcon)
        binding.textPrecipNumList.text = item.precipitation.toString()
        binding.textWindNumList.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}