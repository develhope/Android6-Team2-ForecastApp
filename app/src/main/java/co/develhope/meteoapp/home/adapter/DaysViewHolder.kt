package co.develhope.meteoapp.home.adapter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.home.setWeatherIcon
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class DaysViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: Days, onClick: (WeekItems) -> Unit) {
        val tomorrow = OffsetDateTime.now().plusDays(1)

        if (item.date.dayOfMonth == tomorrow.dayOfMonth){
            //Le stringhe hardcoded non devono esistere, create la risorsa stringa che vi serve e usatela da subito
            binding.textDayOfWeekList.text = "DOMANI"
        }else{
            binding.textDayOfWeekList.text = item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
        }
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
