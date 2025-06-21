package com.example.sadarapp.ui.darah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sadarapp.R
import com.example.sadarapp.data.model.Darah
import com.example.sadarapp.databinding.ActivityDarahDetailsBinding

class DarahDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDarahDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDarahDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.BtnBack.setOnClickListener {
            finish()
        }

        val darahList = listOf(
            Darah("A+", 12, R.drawable.a_plus),
            Darah("B+", 12, R.drawable.b_plus),
            Darah("O+", 12, R.drawable.o_plus),
            Darah("AB+", 12, R.drawable.ab_plus),
            Darah("A-", 12, R.drawable.a_min),
            Darah("B-", 12, R.drawable.b_min),
            Darah("O-", 12, R.drawable.o_min),
            Darah("AB-", 12, R.drawable.ab_min),
        )

        val adapter = StokDarahAdapter(darahList)
        binding.rvStokDarah.layoutManager = GridLayoutManager(this, 4)
        binding.rvStokDarah.adapter = adapter
    }
}
