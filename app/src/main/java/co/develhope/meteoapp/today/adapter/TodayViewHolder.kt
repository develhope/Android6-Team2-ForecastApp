package co.develhope.meteoapp.today.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.data.domain.WeatherIcon.NOTAVAILABLE
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN_CLOUD
import co.develhope.meteoapp.databinding.ListTodayScreenBinding
import co.develhope.meteoapp.home.setWeatherIcon
import co.develhope.meteoapp.today.HourlyForecastItems
import co.develhope.meteoapp.today.getWeatherIconbasedonId
import org.threeten.bp.format.DateTimeFormatter

open class TodayViewHolder(val binding: ListTodayScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: HourlyForecastItems.Forecast,
        position: Int,
        openedItems: MutableList<Int>,
        onClick: () -> Unit
    ) {
        binding.todayTimeTv.text = item.forecast.date.format(DateTimeFormatter.ofPattern("HH:mm"))

       binding.weatherTodayImage.setWeatherIcon(getWeatherIconbasedonId(item.forecast.forecastIndex))
        binding.degreesToday.text = "${item.forecast.hourlyTemp}°"
        binding.rainChanceTv.text = "${item.forecast.possibleRain}%"
        binding.perceivedDegreesToday.text = "${item.forecast.apparentTemp}°"
        binding.humidityPercentageToday.text = "${item.forecast.humidity}%"
        binding.windSpeedToday.text = "${item.forecast.windDirection} ${item.forecast.windSpeed} km/h"
        binding.coverageToday.text = "${item.forecast.cloudyness}%"
        binding.rainToday.text = "${item.forecast.rain}cm"

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