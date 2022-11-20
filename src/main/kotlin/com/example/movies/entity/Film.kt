package com.example.movies.entity

import java.util.*
import javax.persistence.*

@Entity
class Film(
    @Id var filmId: Long,
    var title: String,
    var description: String,
    var releaseYear: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    var language: Language,

    var rentalDuration: Int,
    var rentalRate: Double,
    var lastUpdate: Date,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "film_actor",
        joinColumns = [JoinColumn(name = "film_id")],
        inverseJoinColumns = [JoinColumn(name = "actor_id")])
    var actors: List<Actor> = mutableListOf(),

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
    name = "film_category",
    joinColumns = [JoinColumn(name = "film_id")],
    inverseJoinColumns = [JoinColumn(name = "category_id")])
    var categories: List<Category> = mutableListOf()
)