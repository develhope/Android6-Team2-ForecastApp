package co.develhope.meteoapp.home.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.data.domain.setWeatherIcon
import org.threeten.bp.format.DateTimeFormatter

class TodayViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Today, onClick: (WeekItems) -> Unit) {
        binding.textDayOfWeekList.text = binding.root.context.getString(R.string.oggi)
        binding.textDayOfMonthList.text =
            item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        binding.textMinNumList.text =
            itemView.resources.getString(R.string.degrees, item.minTemperature.toString())
        binding.textMaxNumList.text =
            itemView.resources.getString(R.string.degrees,item.maxTemperature.toString())
        binding.imgSkyList.setWeatherIcon(item.weatherIcon)
        binding.textPrecipNumList.text =
            itemView.resources.getString(R.string.millimetres, item.precipitation.toString())
        binding.textWindNumList.text =
            itemView.resources.getString(R.string.kilometers_per_hour, item.windSpeed.toString())
        binding.root.setOnClickListener {
            binding.root.findNavController().navigate(R.id.today_screen)
            onClick(item)
        }
    }
}
