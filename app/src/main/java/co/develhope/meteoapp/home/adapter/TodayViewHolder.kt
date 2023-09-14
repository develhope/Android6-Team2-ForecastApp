package co.develhope.meteoapp.home.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.home.setWeatherIcon
import org.threeten.bp.format.DateTimeFormatter

class TodayViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Today, onClick: (WeekItems) -> Unit) {
        binding.textDayOfWeekList.text = binding.root.context.getString(R.string.oggi)
        binding.textDayOfMonthList.text = item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        binding.textMinNumList.text = "${item.minTemperature}°"
        binding.textMaxNumList.text = "${item.maxTemperature}°"
        binding.imgSkyList.setWeatherIcon(item.weatherIcon)
        binding.textPrecipNumList.text = "${item.precipitation} mm"
        binding.textWindNumList.text = "${item.windSpeed} km/h"
        binding.root.setOnClickListener {
            binding.root.findNavController().navigate(R.id.today_screen)
            onClick(item)
        }
    }
}
