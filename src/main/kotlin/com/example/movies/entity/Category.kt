package com.example.movies.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Category (
    @Id var categoryId : Long,
    var name: String,
    var lastUpdate: Date,
    @ManyToMany(mappedBy = "categories")
    var films: List<Film> = mutableListOf()
)