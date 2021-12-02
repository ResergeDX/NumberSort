package com.example.numbersort

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numbersort.databinding.NumberElementBinding

class Adaptador(context: Context, datos: ArrayList<Int>): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    private val numbers=datos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = NumberElementBinding.inflate(layoutInflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adaptador.ViewHolder, position: Int) {
        holder.bindData(numbers[position])

    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    class ViewHolder(binding: NumberElementBinding): RecyclerView.ViewHolder(binding.root){
        private val tvNumberGet=binding.tvNumerGet

        fun bindData(item:Int){
            tvNumberGet.text=item.toString()
        }
    }

}