package co.develhope.meteoapp.tomorrow.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.TitleTodayScreenBinding
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class TomorrowTitleViewHolder(private val binding: TitleTodayScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun capitalizeWords(input: String): String {
        return input.split(" ").joinToString(" ") { it.capitalize() }
    }

    fun onBind(item: HourlyForecastItems.Title) {
        val currentDate = LocalDate.now()

        val formattedDate = capitalizeWords(
            currentDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        binding.todayLocationTv.text = item.todayLocation
        binding.todaySubtitleLongTv.text = formattedDate
    }
}