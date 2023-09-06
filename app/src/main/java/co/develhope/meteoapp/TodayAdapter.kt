package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.GONE
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.ListTodayScreenBinding

class TodayAdapter(val todayList: List<TodayData>): Adapter<TodayAdapter.TodayViewHolder>(){

    class TodayViewHolder(val binding: ListTodayScreenBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        return TodayViewHolder(ListTodayScreenBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return todayList.size
    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        val model = todayList[position]

        holder.binding.todayTimeTv.text = model.todayTime
        holder.binding.weatherTodayImage.setImageResource(model.todayWeatherImage)
        holder.binding.degreesToday.text = model.todayDegrees
        holder.binding.rainChanceImage.setImageResource(model.todayRainChanceImage)
        holder.binding.rainChanceTv.text = model.todayRainChance
        holder.binding.arrowImageToday.setImageResource(model.todayArrowImage)
        holder.binding.perceivedTvToday.text = model.todayPerceivedTitle
        holder.binding.perceivedDegreesToday.text = model.todayPerceived
        holder.binding.uvIndexTvToday.text = model.todayUvIndexTitle
        holder.binding.uvIndexToday.text = model.todayUvIndex
        holder.binding.humidityTvToday.text = model.todayHumidityTitle
        holder.binding.humidityPercentageToday.text = model.todayHumidity
        holder.binding.windTvToday.text = model.todayWindTitle
        holder.binding.windSpeedToday.text = model.todayWind
        holder.binding.coverageTvToday.text = model.todayCoverageTitle
        holder.binding.coverageToday.text = model.todayCoverage
        holder.binding.rainTvToday.text = model.todayRainHeightTitle
        holder.binding.rainToday.text = model.todayRainHeight
    }

}