package com.mintic.app.jellyapp;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class CityAdapter(
    private val mCity: ArrayList<City>,
    private val context: Context,
    private val onClick: (City) -> Unit
    ) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.city_display_layout, parent, false)
            return CityViewHolder(view)
        }

        override fun onBindViewHolder(holderCity: CityViewHolder, position: Int)
        {
            val city = mCity[position]
            holderCity.bind(city = city)
        }


        //Retorna la cantidad de elementos mi lista
        override fun getItemCount(): Int
        {
            return mCity.size
        }

        inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {
            private var nameLabel: TextView = itemView.findViewById(R.id.text_city)
            private var imageView: ImageView = itemView.findViewById(R.id.image_city)
            private var ratCityBar: RatingBar = itemView.findViewById(R.id.ratcityBar)
            private var descriptionShort: TextView = itemView.findViewById(R.id.descriptionShort)
            private var currentCity: City? = null

            init {
                itemView.setOnClickListener {
                    currentCity?.let {
                        onClick(it)
                    }
                }
            }

            /* Bind Contact name and image. */
            fun bind(city: City) {

                currentCity = city
                nameLabel.text = city.cityName
                ratCityBar.rating = city.ratCityValue.toFloat()
                descriptionShort.text = city.cityDescription


                Glide.with(context)
                    .load(city.imageUrl)
                    .into(imageView)
            }
        }
}
