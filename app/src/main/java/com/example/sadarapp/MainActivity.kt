package com.example.sadarapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sadarapp.data.api.RetrofitClient
import com.example.sadarapp.data.model.Faskes

import com.example.sadarapp.databinding.ActivityMainBinding
import com.example.sadarapp.ui.faskes.FaskesAdapter


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        fetchLogs()
    }

    private fun fetchLogs() {

        RetrofitClient.instance.getParkingLogs().enqueue(object : Callback<List<Faskes>> {

            override fun onResponse(call: Call<List<Faskes>>, response: Response<List<Faskes>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        val adapter = FaskesAdapter(data)
                        binding.recyclerView.adapter = adapter
                    } else {

                        Toast.makeText(this@MainActivity, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
                    }
                } else {

                    Toast.makeText(this@MainActivity, "Gagal memuat data: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Faskes>>, t: Throwable) {

                Toast.makeText(this@MainActivity, "Gagal terhubung ke server: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}