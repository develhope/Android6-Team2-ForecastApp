package co.develhope.meteoapp.ui.home.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.HomeTitleBinding
import co.develhope.meteoapp.ui.home.adapter.WeekItems.HomeTitle

class TitleViewHolder(private val binding: HomeTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeTitle, onClick: (WeekItems) -> Unit) {
        //TODO c'è la possibilità di fargl iarrivare il dato tramite l'ogetto della sealed class perchè creare una dipendenza esterna per ottenere il dato?
        binding.homeTitle.text = Data.getCityLocation(binding.root.context)
        binding.root.setOnClickListener {
            //TODO la navigazione va gestita nel fragment non nel viewholder, c'è la funzione onClick propprio per fare questo
            binding.root.findNavController().navigate(R.id.search_screen)
            onClick(item)
        }
    }
}