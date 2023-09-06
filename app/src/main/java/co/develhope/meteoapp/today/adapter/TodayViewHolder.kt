package co.develhope.meteoapp.today.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.ListTodayScreenBinding
import co.develhope.meteoapp.today.TodayData

open class TodayViewHolder(val binding: ListTodayScreenBinding) : RecyclerView.ViewHolder(binding.root){
    fun onBind(item: TodayData.TodayItem){
        binding.todayTimeTv.text = item.todayTime
        binding.weatherTodayImage.setImageResource(item.todayWeatherImage)
        binding.degreesToday.text = item.todayDegrees
        binding.rainChanceImage.setImageResource(item.todayRainChanceImage)
        binding.rainChanceTv.text = item.todayRainChance
        binding.arrowImageToday.setImageResource(item.todayArrowImage)
        binding.perceivedTvToday.text = item.todayPerceivedTitle
        binding.perceivedDegreesToday.text = item.todayPerceived
        binding.uvIndexTvToday.text = item.todayUvIndexTitle
        binding.uvIndexToday.text = item.todayUvIndex
        binding.humidityTvToday.text = item.todayHumidityTitle
        binding.humidityPercentageToday.text = item.todayHumidity
        binding.windTvToday.text = item.todayWindTitle
        binding.windSpeedToday.text = item.todayWind
        binding.coverageTvToday.text = item.todayCoverageTitle
        binding.coverageToday.text = item.todayCoverage
        binding.rainTvToday.text = item.todayRainHeightTitle
        binding.rainToday.text = item.todayRainHeight

        binding.arrowImageToday.setOnClickListener {

            binding.arrowImageToday.animate().apply {
                rotationXBy(180f)
            }

            // Toggle visibility of the CardView
            if (binding.todayCardview.visibility == View.VISIBLE) {

                binding.todayCardview.visibility = View.GONE
            } else {
                binding.todayCardview.visibility = View.VISIBLE
            }
        }
    }
}