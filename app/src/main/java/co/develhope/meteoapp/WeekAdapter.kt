package co.develhope.meteoapp

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.WeekItems.Companion.DaysId
import co.develhope.meteoapp.WeekItems.Companion.HomeSubtitleId
import co.develhope.meteoapp.WeekItems.Companion.HomeTitleId
import co.develhope.meteoapp.WeekItems.Companion.TodayId
import co.develhope.meteoapp.databinding.HomeSubtitleBinding
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

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
            HomeTitleId -> TitleViewHolder(HomeTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            HomeSubtitleId -> SubtitleViewHolder(HomeSubtitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw Exception("Invalid ViewHolder Type")
        }
    }

    override fun getItemCount(): Int = list.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is TodayViewHolder -> holder.bind(item as WeekItems.Today, onClick)
            is DaysViewHolder -> holder.bind(item as WeekItems.Days, onClick)
            is TitleViewHolder -> holder.bind(item as WeekItems.HomeTitle)
            is SubtitleViewHolder -> holder.bind(item as WeekItems.HomeSubtitle)
            else -> throw Exception("Invalid ViewHolder Not Recognized")
        }
    }
}

private fun ImageView.setImageResource(weatherIcon: DailySummaryForecast.WeatherIcon) {

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
        binding.imgSkyList.setImageResource(item.weatherIcon)
        binding.textPrecipNumList.text = item.precipitation.toString()
        binding.textWindNumList.text = item.windSpeed.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}

class TitleViewHolder(private val binding: HomeTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: WeekItems.HomeTitle) {

    }
}

class SubtitleViewHolder(private val binding: HomeSubtitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: WeekItems.HomeSubtitle) {

    }
}