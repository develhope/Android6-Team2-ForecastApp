package co.develhope.meteoapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.ListTodayScreenBinding

open class TodayViewHolder(val binding: ListTodayScreenBinding) : RecyclerView.ViewHolder(binding.root){
    fun onBind(model: TodayData.TodayItem){
        binding.todayTimeTv.text = model.todayTime
        binding.weatherTodayImage.setImageResource(model.todayWeatherImage)
        binding.degreesToday.text = model.todayDegrees
        binding.rainChanceImage.setImageResource(model.todayRainChanceImage)
        binding.rainChanceTv.text = model.todayRainChance
        binding.arrowImageToday.setImageResource(model.todayArrowImage)
        binding.perceivedTvToday.text = model.todayPerceivedTitle
        binding.perceivedDegreesToday.text = model.todayPerceived
        binding.uvIndexTvToday.text = model.todayUvIndexTitle
        binding.uvIndexToday.text = model.todayUvIndex
        binding.humidityTvToday.text = model.todayHumidityTitle
        binding.humidityPercentageToday.text = model.todayHumidity
        binding.windTvToday.text = model.todayWindTitle
        binding.windSpeedToday.text = model.todayWind
        binding.coverageTvToday.text = model.todayCoverageTitle
        binding.coverageToday.text = model.todayCoverage
        binding.rainTvToday.text = model.todayRainHeightTitle
        binding.rainToday.text = model.todayRainHeight

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