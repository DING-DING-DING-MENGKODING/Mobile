package com.example.sadarapp.ui.oksigen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sadarapp.R
import com.example.sadarapp.data.model.Darah
import com.example.sadarapp.databinding.ActivityCariOksigenBinding
import com.example.sadarapp.databinding.ActivityDarahDetailsBinding
import com.example.sadarapp.databinding.ActivityOksigenDetailBinding
import com.example.sadarapp.ui.darah.StokDarahAdapter

class OksigenDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOksigenDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOksigenDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.BtnBack.setOnClickListener {
            finish()
        }

        val darahList = listOf(
            Darah("A+", 12, R.drawable.k_1),
            Darah("B+", 12, R.drawable.k_2),
            Darah("O+", 12, R.drawable.k_3),
            Darah("AB+", 12, R.drawable.k_4),
            Darah("A-", 12, R.drawable.k_5),
            Darah("B-", 12, R.drawable.k_6),
            Darah("O-", 12, R.drawable.k_7),
        )

        val adapter = StokDarahAdapter(darahList)
        binding.rvStokOksigen.layoutManager = GridLayoutManager(this, 4)
        binding.rvStokOksigen.adapter = adapter
    }
}