package com.example.lab2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        val adapter = MoviesAdapter(movies(), this::onContactItemClicked)
        list.adapter = adapter
    }

    private fun onContactItemClicked(item: MovieItem) {
        Toast.makeText(this, "Movie: ${item.name} clicked!", Toast.LENGTH_SHORT).show()
    }
}