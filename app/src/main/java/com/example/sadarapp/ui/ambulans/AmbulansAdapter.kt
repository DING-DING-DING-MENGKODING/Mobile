package com.example.sadarapp.ui.ambulans

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sadarapp.data.model.Faskes
import com.example.sadarapp.databinding.ItemAmbulansBinding

class AmbulansAdapter(
    private val list: List<Faskes>
) : RecyclerView.Adapter<AmbulansAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAmbulansBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAmbulansBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val faskes = list[position]
        holder.binding.apply {
            tvNamaRS.text = faskes.nama
            tvAlamatRS.text = "${faskes.lokasi} (3 Km)"
            tvStokDarah.text = "Ketersediaan Unit: "
            imgBlood.setImageResource(faskes.bloodIcon)
            root.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, AmbulansDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}
