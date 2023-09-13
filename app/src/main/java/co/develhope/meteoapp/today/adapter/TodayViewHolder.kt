package co.develhope.meteoapp.today.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.ListTodayScreenBinding
import co.develhope.meteoapp.today.TodayData
import org.threeten.bp.format.DateTimeFormatter

open class TodayViewHolder(val binding: ListTodayScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: TodayData.TodayItem,
        position: Int,
        openedItems: MutableList<Int>,
        onClick: () -> Unit
    ) {
        binding.todayTimeTv.text = item.todayTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        binding.weatherTodayImage.setImageResource(item.todayWeatherImage)
        binding.degreesToday.text = "${item.todayDegrees}°"
        binding.rainChanceTv.text = "${item.todayRainChance}%"
        binding.perceivedDegreesToday.text = "${item.todayPerceived}°"
        binding.humidityPercentageToday.text = "${item.todayHumidity}%"
        binding.windSpeedToday.text = "SSE ${item.todayWind}km/h"
        binding.coverageToday.text = "${item.todayCoverage}%"
        binding.rainToday.text = "${item.todayRainHeight}cm"

        // Toggle visibility of the CardView
        if (position in openedItems) {
            binding.arrowImageToday.rotation = 180f
            binding.todayCardview.visibility = View.VISIBLE
        } else {
            binding.arrowImageToday.rotation = 0f
            binding.todayCardview.visibility = View.GONE
        }

        binding.root.setOnClickListener {
            if (position in openedItems) openedItems.remove(position)
            else openedItems.add(position)

            onClick()
        }
    }
}