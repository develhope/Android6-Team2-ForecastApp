package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.develhope.meteoapp.databinding.FragmentErrorScreenBinding
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding


class ErrorScreenFragment : Fragment() {

    private var _binding: FragmentErrorScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding().inflate(inflater, container, false)

        return binding.root
    }





}