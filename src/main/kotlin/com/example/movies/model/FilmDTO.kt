package com.example.movies.model

import java.util.*

class FilmDTO (
    var filmId: Long,
    var title: String,
    var description: String,
    var releaseYear: Date,
    var language: String,
    var rentalDuration: Int,
    var rentalRate: Double,
    var actors: List<String>,
    var categories: List<String>
)