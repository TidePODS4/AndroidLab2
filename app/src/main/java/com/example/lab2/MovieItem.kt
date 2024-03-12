package com.example.lab2

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.util.Date
import java.util.Random
import kotlin.math.abs


data class MovieItem(val name: String, val rating: Int, val releaseDate: LocalDate)

val random : Random = Random()

fun movies(): List<MovieItem> =
    MutableList(20) { index -> MovieItem(
        name = "Фильм $index", random.nextInt(11), generateRandomDate(random.nextInt(30))
    ) }

fun generateRandomDate(yearDiff : Int): LocalDate {
    val endYear = LocalDate.now().year
    val startYear = endYear - yearDiff
    val year = random.nextInt(endYear - startYear + 1) + startYear
    val month = random.nextInt(12) + 1
    val day = random.nextInt(28) + 1
    return LocalDate.of(year, month, day)
}