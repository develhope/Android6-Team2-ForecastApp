package co.develhope.meteoapp.ui.error_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.databinding.FragmentErrorScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorScreenFragment : Fragment() {

    private var _binding: FragmentErrorScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentErrorScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.errorRetryButton.setOnClickListener {

        }
    }
}