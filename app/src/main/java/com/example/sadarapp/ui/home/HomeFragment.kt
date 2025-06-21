package com.example.sadarapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sadarapp.databinding.FragmentHomeBinding
import com.example.sadarapp.ui.ambulans.CariAmbulansActivity
import com.example.sadarapp.ui.darah.CariKantongDarahActivity
import com.example.sadarapp.ui.oksigen.CariOksigenActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.CariKantongDarah.setOnClickListener {
            val intent = Intent(requireContext(), CariKantongDarahActivity::class.java)
            startActivity(intent)
        }

        binding.CariAmbulans.setOnClickListener {
            val intent = Intent(requireContext(), CariAmbulansActivity::class.java)
            startActivity(intent)
        }

        binding.CariOksigen.setOnClickListener {
            val intent = Intent(requireContext(), CariOksigenActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
