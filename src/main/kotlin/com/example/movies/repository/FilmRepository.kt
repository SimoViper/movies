package com.example.movies.repository

import com.example.movies.entity.Film
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FilmRepository : CrudRepository<Film, Long> {
    override fun findAll(): List<Film>
    override fun findById(id: Long): Optional<Film>
    fun findByTitle(title: String): Film?
}
