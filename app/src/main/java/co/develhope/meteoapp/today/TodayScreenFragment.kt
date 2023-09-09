package co.develhope.meteoapp.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding
import co.develhope.meteoapp.today.adapter.TodayAdapter

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
            TodayData.TodayTitle("Palermo,Sicilia"),
            TodayData.TodayItem(
                "12:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "13:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "14:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "15:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "16:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "17:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "18:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "19:00",
                R.drawable.sun,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "20:00",
                R.drawable.moon,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "21:00",
                R.drawable.moon,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "22:00",
                R.drawable.moon,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "23:00",
                R.drawable.moon,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
            TodayData.TodayItem(
                "00:00",
                R.drawable.moon,
                (0..30).random(),
                (0..100).random(),
                (0..30).random(),
                "1/10",
                (0..100).random(),
                (0..5).random(),
                (0..100).random(),
                (0..5).random()
            ),
        )


        binding.todayRecyclerview.adapter = TodayAdapter(todayList)

    }
}