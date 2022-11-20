package com.example.movies.controller

import com.example.movies.model.FilmDTO
import com.example.movies.model.MoviesResponse
import com.example.movies.service.FilmService
import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/film")
class FilmController
@Autowired constructor(
    val filmService: FilmService
) {

    @GetMapping
    fun getFilms(
        @RequestParam(required = false, name = "title") title: String?,
        @RequestParam(required = false, name = "category") category: String?,
        @RequestParam(required = false, name = "actor_name") actorFirstName: String?,
        @RequestParam(required = false, name = "actor_surname") actorLastName: String?
    ): MoviesResponse {
        return MoviesResponse(films = filmService.getFilms(title, category, actorFirstName, actorLastName))
    }
}