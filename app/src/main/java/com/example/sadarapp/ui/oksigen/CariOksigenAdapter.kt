package com.example.sadarapp.ui.oksigen

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sadarapp.data.model.Faskes
import com.example.sadarapp.databinding.ItemOksigenBinding
import com.example.sadarapp.ui.darah.DarahDetailsActivity

class CariOksigenAdapter(private val hospitals: List<Faskes>) :
    RecyclerView.Adapter<CariOksigenAdapter.OksigenViewHolder>() {

    inner class OksigenViewHolder(val binding: ItemOksigenBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OksigenViewHolder {
        val binding = ItemOksigenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OksigenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OksigenViewHolder, position: Int) {
        val hospital = hospitals[position]
        holder.binding.apply {
            tvNamaRS.text = hospital.nama
            tvAlamatRS.text = "${hospital.lokasi} (4 Km)"
            imgBlood.setImageResource(hospital.bloodIcon)
            root.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, OksigenDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = hospitals.size
}
