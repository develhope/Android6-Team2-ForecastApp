package co.develhope.meteoapp.ui.welcome_screen

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.FragmentWelcomeScreenBinding
import co.develhope.meteoapp.ui.MainActivity
import co.develhope.meteoapp.ui.isNetworkAvailable


class WelcomeScreen : Fragment() {

    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                }
            }
        )

        binding.welcomeButton.setOnClickListener {
            if (isNetworkAvailable(requireContext())) {
                if (hasLocationPermission()) {
                    findNavController().navigate(R.id.home_screen)
                    (activity as? MainActivity)?.setBottomNavVisibility(View.VISIBLE)
                } else {
                    findNavController().navigate(R.id.search_screen)
                    (activity as? MainActivity)?.setBottomNavVisibility(View.GONE)
                }
            } else {
                findNavController().navigate(R.id.error_screen)
                (activity as? MainActivity)?.setBottomNavVisibility(View.GONE)
            }
        }

    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
}
