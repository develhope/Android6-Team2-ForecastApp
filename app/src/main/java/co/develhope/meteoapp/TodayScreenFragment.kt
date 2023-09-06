package co.develhope.meteoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding

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

        val todayList: List<TodayData> = listOf(
            TodayData.TodayItem(
                "12:00",
                R.drawable.sun,
                "30°",
                R.drawable.droplet,
                "0%",
                R.drawable.arrow,
                "Percepita",
                "22°",
                "Indice UV,",
                "1/10",
                "Umidità",
                "60%",
                "Vento",
                "SSE 7km/h",
                "Copertura",
                "24%",
                "Pioggia",
                "0cm"
            ),
            TodayData.TodayItem(
                "13:00",
                R.drawable.sun_cloud,
                "28°",
                R.drawable.droplet,
                "1%",
                R.drawable.arrow,
                "Percepita",
                "25°",
                "Indice UV,",
                "1/10",
                "Umidità",
                "50%",
                "Vento",
                "SSE 3km/h",
                "Copertura",
                "28%",
                "Pioggia",
                "0cm"
            ),
            TodayData.TodayItem(
                "14:00",
                R.drawable.sun_cloud,
                "27°",
                R.drawable.droplet,
                "0%",
                R.drawable.arrow,
                "Percepita",
                "22°",
                "Indice UV,",
                "1/10",
                "Umidità",
                "60%",
                "Vento",
                "SSE 5km/h",
                "Copertura",
                "24%",
                "Pioggia",
                "0cm"
            ),
            TodayData.TodayItem(
                "15:00",
                R.drawable.sun_cloud,
                "27°",
                R.drawable.droplet,
                "0%",
                R.drawable.arrow,
                "Percepita",
                "22°",
                "Indice UV,",
                "1/10",
                "Umidità",
                "60%",
                "Vento",
                "SSE 7km/h",
                "Copertura",
                "24%",
                "Pioggia",
                "0cm"
            ),
            TodayData.TodayItem(
                "16:00",
                R.drawable.sun,
                "27°",
                R.drawable.droplet,
                "0%",
                R.drawable.arrow,
                "Percepita",
                "22°",
                "Indice UV,",
                "1/10",
                "Umidità",
                "60%",
                "Vento",
                "SSE 7km/h",
                "Copertura",
                "24%",
                "Pioggia",
                "0cm"
            )
        )

        binding.todayRecyclerview.adapter = TodayAdapter(todayList)

    }
}