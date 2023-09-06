package co.develhope.meteoapp.home.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.home.WeekItems.Companion.DaysId
import co.develhope.meteoapp.home.WeekItems.Companion.HomeSubtitleId
import co.develhope.meteoapp.home.WeekItems.Companion.HomeTitleId
import co.develhope.meteoapp.home.WeekItems.Companion.TodayId
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.home.WeekItems.HomeSubtitle
import co.develhope.meteoapp.home.WeekItems.HomeTitle
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.databinding.HomeSubtitleBinding
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.databinding.ListHomeScreenBinding
import co.develhope.meteoapp.home.WeekItems
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class WeekAdapter(private val list: List<WeekItems>, private val onClick: (WeekItems) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return item.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("WeekAdapter", "viewType is $viewType")
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
        Log.d("WeekAdapter", "holder is $holder")

        when (holder) {
            is TodayViewHolder -> holder.bind(item as Today, onClick)
            is DaysViewHolder -> holder.bind(item as Days, onClick)
            is TitleViewHolder -> holder.bind(item as HomeTitle)
            is SubtitleViewHolder -> holder.bind(item as HomeSubtitle)
            else -> throw Exception("Invalid ViewHolder Not Recognized")
        }
    }
}


