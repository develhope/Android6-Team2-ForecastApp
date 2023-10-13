package co.develhope.meteoapp.tomorrow.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.TitleTodayScreenBinding
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class TomorrowTitleViewHolder(private val binding: TitleTodayScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun capitalizeWords(input: String): String {
        return input.split(" ").joinToString(" ") { it.capitalize() }
    }

    fun onBind(item: HourlyForecastItems.Title) {
        val currentDate = Data.getSavedDate()

        val fullDate = capitalizeWords(
            currentDate!!.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d MMMM",
                    Locale.ITALIAN
                )
            )
        )

        val formattedWeekDay = capitalizeWords(currentDate.format(DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN)))

        val tomorrow = OffsetDateTime.now().plusDays(1)

        val weekDay = currentDate.dayOfMonth

        if (weekDay == tomorrow.dayOfMonth) {
            binding.todaySubtitleShortTv.text = binding.root.context.getString(R.string.domani)
        } else{
            binding.todaySubtitleShortTv.text = formattedWeekDay
        }

        binding.todayLocationTv.text = item.todayLocation
        binding.todaySubtitleLongTv.text = fullDate
    }
}