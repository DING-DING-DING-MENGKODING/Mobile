package com.example.sadarapp.ui.ambulans

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sadarapp.R
import com.example.sadarapp.data.model.Faskes
import com.example.sadarapp.databinding.ActivityCariAmbulansBinding

class CariAmbulansActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCariAmbulansBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCariAmbulansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ambulanceList = listOf(
            Faskes("RSUD Bhayangkara Makassar", "Jl. Sangkuriang", 3.3, 4.0, R.drawable.ambulans),
            Faskes("RS Stella Maris", "Jl. Jend. Sudirman", 2.0, 3.5, R.drawable.ambulans),
            Faskes("RS Labuang Baji", "Jl. DR. Ratulangi", 1.5, 2.0, R.drawable.ambulans)
        )

        binding.recyclerViewAmbulans.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAmbulans.adapter = AmbulansAdapter(ambulanceList)



        binding.BtnBack.setOnClickListener {
            finish()
        }
    }
}
