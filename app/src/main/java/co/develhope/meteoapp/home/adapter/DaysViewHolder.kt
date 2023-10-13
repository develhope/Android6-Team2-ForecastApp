package co.develhope.meteoapp.home.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.setWeatherIcon
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.today.getWeatherIconbasedonId
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class DaysViewHolder(private val binding: ListHomeScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Days, onClick: (WeekItems) -> Unit) {
        val tomorrow = OffsetDateTime.now().plusDays(1)

        if (item.forecast.date.dayOfMonth == tomorrow.dayOfMonth) {
            binding.textDayOfWeekList.text = binding.root.context.getString(R.string.domani)

        } else {
            binding.textDayOfWeekList.text =
                item.forecast.date.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN))
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        binding.textDayOfMonthList.text =
            item.forecast.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        binding.textMinNumList.text =
            itemView.resources.getString(R.string.degrees, item.forecast.minTemperature.toString())
        binding.textMaxNumList.text =
            itemView.resources.getString(R.string.degrees, item.forecast.maxTemperature.toString())
        binding.imgSkyList.setWeatherIcon(getWeatherIconbasedonId(1, item.forecast.weatherIcon))
        binding.textPrecipNumList.text =
            itemView.resources.getString(
                R.string.millimetres,
                item.forecast.precipitation.toString()
            )
        binding.textWindNumList.text =
            itemView.resources.getString(
                R.string.kilometers_per_hour,
                item.forecast.windSpeed.toString()
            )
        binding.root.setOnClickListener {
            Data.saveDate(item.forecast.date)
            binding.root.findNavController().navigate(R.id.action_home_screen_to_tomorrow_screen)
            onClick(item)
        }


    }
}
