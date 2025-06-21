package com.example.sadarapp.ui.darah

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sadarapp.data.model.Faskes
import com.example.sadarapp.databinding.ItemDarahBinding
import com.example.sadarapp.ui.ambulans.AmbulansDetailActivity


class KantongDarahAdapter(private val hospitals: List<Faskes>) :
    RecyclerView.Adapter<KantongDarahAdapter.KantongDarahViewHolder>() {

    inner class KantongDarahViewHolder(val binding: ItemDarahBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KantongDarahViewHolder {
        val binding = ItemDarahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KantongDarahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KantongDarahViewHolder, position: Int) {
        val hospital = hospitals[position]
        holder.binding.apply {
            tvNamaRS.text = hospital.nama
            tvAlamatRS.text = "${hospital.lokasi} ( 30 Km)"
            imgBlood.setImageResource(hospital.bloodIcon)
            root.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, DarahDetailsActivity::class.java)
                context.startActivity(intent)
            }
        }


    }

    override fun getItemCount(): Int = hospitals.size
}
