package com.aisyah.boardinglogressfirstproject_haura

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//membuat introslides untuk mengubah datanya menjadi bentuk list
class IntroSliderAdapter(private val introSlides: List<IntroSlide>) :
//kalo buat adapter harus ada kodingan ini
    RecyclerView.Adapter<IntroSliderAdapter.IntroSliderViewHolder>() {
    inner class IntroSliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //inisialisasi = panggil id per widget
        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val imageIcon = view.findViewById<ImageView>(R.id.imageIcon)

        //function bind untuk mengikat widget2 nya dengan data
        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            textDescription.text = introSlide.description
            imageIcon.setImageResource(introSlide.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSliderViewHolder {
        return IntroSliderViewHolder(
            //onCreateViewHolder = untuk manggil layout yang kita buat untuk naro data
            LayoutInflater.from(parent.context).inflate(R.layout.slide_item, parent, false)
        )
    }


    override fun getItemCount(): Int {
        //buat ngitung si list nya ada berapa
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSliderViewHolder, position: Int) {
        //buat nge set up widget2nya
        //buat mengikat widget2 nya dengan data
        holder.bind(introSlides[position])
    }
}