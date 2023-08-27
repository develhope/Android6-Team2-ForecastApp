package co.develhope.meteoapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object {
            @RequiresApi(Build.VERSION_CODES.O)
            fun getWeatherDataList(): List<HomeScreenList> {
                val currentDate = LocalDate.now()
                val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val formattedDate = currentDate.format(dateFormatter)

                val dayOfTheWeek = LocalDate.now().dayOfWeek
                val dayOfWeekText = dayOfTheWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())

                return listOf(
                    HomeScreenList(dayOfWeekText, formattedDate, 22, 30,
                        MainActivity.weatherIcons.sun, 0, 10),
                    HomeScreenList(dayOfWeekText, formattedDate, 20, 28,
                        MainActivity.weatherIcons.rain, 60, 15),
                    HomeScreenList(dayOfWeekText, formattedDate, 23, 31,
                        MainActivity.weatherIcons.sun_cloud, 0, 12)

                )
            }
        }

        //TODO remove comments below when HomeListAdapter is created
       // val list = findViewById<RecyclerView>(R.id.home_recycler_view)
       // val adapter = HomeListAdapter()
       // list.adapter = adapter
       // list.layoutManager = LinearLayoutManager(this)

       // adapter.submitList(getWeatherDataList)

    }
}