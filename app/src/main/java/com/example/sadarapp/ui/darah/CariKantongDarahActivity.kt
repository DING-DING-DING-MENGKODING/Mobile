package com.example.sadarapp.ui.darah

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sadarapp.R
import com.example.sadarapp.data.model.Faskes
import com.example.sadarapp.databinding.ActivityCariKantongDarahBinding

class CariKantongDarahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCariKantongDarahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCariKantongDarahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hospitalList = listOf(
            Faskes("RSUD Bhayangkara Makassar", "Jl. Sangkuriang", 363.3, 33.4, R.drawable.ic_card_darah),
            Faskes("RS Stella Maris", "Jl. Jend. Sudirman", 35.5, 23.0, R.drawable.ic_card_darah),
            Faskes("RS Labuang Baji", "Jl. DR. Ratulangi", 3.40, 1.5, R.drawable.ic_card_darah)
        )

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.golongan_darah,
            android.R.layout.simple_spinner_item
        )

        binding.recyclerViewRS.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewRS.adapter = KantongDarahAdapter(hospitalList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGolonganDarah.adapter = adapter

        binding.spinnerGolonganDarah.setOnItemSelectedListener(object :
            android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: android.widget.AdapterView<*>,
                view: android.view.View,
                position: Int,
                id: Long
            ) {
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Dipilih: $item", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {}
        })

        binding.BtnBack.setOnClickListener {
            finish()
        }
    }
}
