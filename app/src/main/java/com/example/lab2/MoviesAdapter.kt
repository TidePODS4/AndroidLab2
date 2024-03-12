package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(
    private val movies: List<MovieItem>,
    private val onItemClicked: (item: MovieItem) -> Unit
) :
    RecyclerView.Adapter<ContactViewHolder>() {

    private fun onViewHolderClicked(position: Int) {
        onItemClicked(movies[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ContactViewHolder(
            view,
            this::onViewHolderClicked
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}

class ContactViewHolder(itemView: View,
                        private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.movie_name)
    private val releaseDate: TextView = itemView.findViewById(R.id.movie_release_date)
    private val rating: TextView = itemView.findViewById(R.id.movie_rating)

    init {
        itemView.setOnClickListener { onItemClicked(adapterPosition) }
    }

    fun bind(item: MovieItem) {
        name.text = item.name
        releaseDate.text = "Дата выхода: ${item.releaseDate}"
        rating.text = "Рейтинг - ${item.rating}"
    }
}