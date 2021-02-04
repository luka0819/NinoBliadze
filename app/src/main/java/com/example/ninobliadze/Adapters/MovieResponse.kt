package com.example.ninobliadze.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ninobliadze.Models.MovieModel
import com.example.ninobliadze.R

class MovieResponse (private val movies: List<MovieModel>) : RecyclerView.Adapter<MovieResponse.MovieViewHolder>(){
    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val  imageview: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.title)
        val overview: TextView = itemView.findViewById(R.id.overview)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.movie_items_activity,parent,false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val a = movies[position]
        Glide.with(holder.imageview.context)
            .load(a.posterUrl)
            .centerCrop()
            .into(holder.imageview)
        holder.title.text= a.title
        holder.overview.text = a.overview



    }

    override fun getItemCount(): Int = movies.size


}