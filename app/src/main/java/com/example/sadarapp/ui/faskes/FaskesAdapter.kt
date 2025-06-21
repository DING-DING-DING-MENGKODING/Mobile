//package com.example.sadarapp.ui.faskes
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.sadarapp.data.model.Faskes
//import com.example.sadarapp.databinding.ItemLogBinding
//
//class FaskesAdapter (private val listFaskes: List<Faskes>) : RecyclerView.Adapter<FaskesAdapter.LogViewHolder>() {
//    inner class LogViewHolder (private val binding: ItemLogBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(faskes: Faskes){
//            binding.tvNamaFaskes.text = faskes.nama
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
//        val binding = ItemLogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return LogViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int = listFaskes.size
//
//    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
//        holder.bind(listFaskes[position])
//    }
//
//
//}