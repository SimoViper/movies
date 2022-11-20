package com.example.movies.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*

@Entity
class Actor (
    @Id var actorId : Long,
    var firstName : String,
    var lastName : String,
    var lastUpdate: Date,
    @ManyToMany(mappedBy = "actors")
    var films: List<Film> = mutableListOf()
)