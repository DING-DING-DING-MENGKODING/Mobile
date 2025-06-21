package com.example.sadarapp.ui.darah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sadarapp.data.model.Darah
import com.example.sadarapp.databinding.ItemJenisItemBinding

class StokDarahAdapter(private val list: List<Darah>) :
    RecyclerView.Adapter<StokDarahAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemJenisItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemJenisItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val darah = list[position]
        holder.binding.apply {
            tvJumlah.text = darah.jumlah.toString()
            imgDarah.setImageResource(darah.iconResId)
        }
    }
}
