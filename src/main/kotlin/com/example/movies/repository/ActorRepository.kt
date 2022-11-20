package com.example.movies.repository

import com.example.movies.entity.Actor
import org.springframework.data.repository.CrudRepository

interface ActorRepository : CrudRepository<Actor, Long> {

    fun findByFirstNameAndLastName(firstName: String, lastName: String): Actor?
    fun findByLastName(lastName: String): List<Actor>?
    fun findByFirstName(firstName: String): List<Actor>?
}