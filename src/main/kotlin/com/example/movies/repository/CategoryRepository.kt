package com.example.movies.repository

import com.example.movies.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {

    fun findByName(name: String): Category?
}