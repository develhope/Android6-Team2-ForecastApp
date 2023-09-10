package co.develhope.meteoapp.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding
import co.develhope.meteoapp.today.adapter.TodayAdapter
import org.threeten.bp.LocalTime
import org.threeten.bp.OffsetTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

class TodayScreenFragment : Fragment() {
    private var _binding: FragmentTodayScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentHour = OffsetTime.now().hour

        val todayList = mutableListOf<TodayData>()

        todayList.add(TodayData.TodayTitle("Palermo, Sicilia"))



        var hour = currentHour

        while(hour <= 23){
            val image = R.drawable.sun
            val degrees = (0..35).random()
            val rainChance = (0..100).random()
            val perceived = degrees - ((0..5).random())
            val humidity = (0..100).random()
            val wind = (0..5).random()
            val coverage = (0..100).random()
            val rainHeight = (0..5).random()

            val todayData = createWeatherData(
                hour,
                image,
                degrees,
                rainChance,
                perceived,
                humidity,
                wind,
                coverage,
                rainHeight
            )
            todayList.add(todayData)

            hour++
        }

        binding.todayRecyclerview.adapter = TodayAdapter(todayList)


    }

    fun createWeatherData(
        hour: Int,
        image: Int,
        degrees: Int,
        rainChance: Int,
        perceived: Int,
        humidity: Int,
        wind: Int,
        coverage: Int,
        rainHeight: Int
    ): TodayData.TodayItem {
        val time = OffsetTime.of(LocalTime.of(hour, 0), ZoneOffset.UTC)
        val formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"))
        return TodayData.TodayItem(
            formattedTime,
            image,
            degrees,
            rainChance,
            perceived,
            humidity,
            wind,
            coverage,
            rainHeight)
    }


}