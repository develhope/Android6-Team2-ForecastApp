package co.develhope.meteoapp.home.adapter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.data.domain.setWeatherIcon
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class DaysViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: Days, onClick: (WeekItems) -> Unit) {
        val tomorrow = OffsetDateTime.now().plusDays(1)

        if (item.date.dayOfMonth == tomorrow.dayOfMonth){
            binding.textDayOfWeekList.text = binding.root.context.getString(R.string.domani)

        }else{
            binding.textDayOfWeekList.text =
                item.date.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN))
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        binding.textDayOfMonthList.text =  item.date.format(DateTimeFormatter.ofPattern("dd/MM"))
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
