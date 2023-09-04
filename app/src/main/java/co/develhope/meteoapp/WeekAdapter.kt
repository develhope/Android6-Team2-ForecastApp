package co.develhope.meteoapp

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.WeekItems.Companion.DaysId
import co.develhope.meteoapp.WeekItems.Companion.SubtitleId
import co.develhope.meteoapp.WeekItems.Companion.TitleId
import co.develhope.meteoapp.WeekItems.Companion.TodayId
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.databinding.SubtitleBinding
import co.develhope.meteoapp.databinding.TitleBinding
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class WeekAdapter(val list: List<WeekItems>, val onClick: (WeekItems) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return item.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TodayId -> TodayViewHolder(ListHomeScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            DaysId -> DaysViewHolder(ListHomeScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TitleId -> TitleViewHolder(TitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            SubtitleId -> SubtitleViewHolder(SubtitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw Exception("Invalid ViewHolder Type")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is TodayViewHolder -> holder.bind(item as WeekItems.Today, onClick)
            is DaysViewHolder -> holder.bind(item as WeekItems.Days, onClick)
            is TitleViewHolder -> holder.bind(item as WeekItems.Title)
            is SubtitleViewHolder -> holder.bind(item as WeekItems.Subtitle)
            else -> throw Exception("Invalid ViewHolder Not Recognized")
        }
    }
}

private fun ImageView.setImageResource(weatherIcon: DailySummaryForecast.weatherIcons) {

}
class TodayViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: WeekItems.Today, onClick: (WeekItems) -> Unit) {
        binding.textDayOfWeekList.text = "OGGI"
        binding.textDayOfMonthList.text = item.date.toString()
        binding.textMinNumList.text = item.minTemperature.toString()
        binding.textMaxNumList.text = item.maxTemperature.toString()
        binding.imgSkyList.setImageResource(item.weatherIcon)
        binding.textPrecipNumList.text = item.precipitation.toString()
        binding.textWindNumList.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}



class DaysViewHolder(private val binding: ListHomeScreenBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: WeekItems.Days, onClick: (WeekItems) -> Unit) {
        val tomorrow = LocalDate.now().plusDays(1).dayOfWeek
        val tomorrowText = tomorrow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        if (item.dayOfWeek == tomorrowText){
            binding.textDayOfWeekList.text = "DOMANI"
        }else{binding.textDayOfWeekList.text = item.dayOfWeek}
        binding.textDayOfMonthList.text = item.date.toString()
        binding.textMinNumList.text = item.minTemperature.toString()
        binding.textMaxNumList.text = item.maxTemperature.toString()
        binding.imgSkyList.setImageResource(item.weatherIcon)
        binding.textPrecipNumList.text = item.precipitation.toString()
        binding.textWindNumList.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}

class TitleViewHolder(private val binding: TitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: WeekItems.Title) {

    }
}

class SubtitleViewHolder(private val binding: SubtitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: WeekItems.Subtitle) {

    }
}