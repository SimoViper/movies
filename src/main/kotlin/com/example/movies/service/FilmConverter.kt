package com.example.movies.service

import com.example.movies.entity.Actor
import com.example.movies.entity.Film
import com.example.movies.model.FilmDTO
import java.util.stream.Collectors

class FilmConverter {

    companion object {
        fun buildActorsFilmDTOs(actors: List<Actor>?): List<FilmDTO> {
            if (!actors.isNullOrEmpty()) {
                val filmDTOs = mutableListOf<FilmDTO>()
                actors.forEach { actor -> filmDTOs.addAll(buildFilmDTOs(actor.films)) }
                return filmDTOs;
            }

            return emptyList();
        }

        fun buildFilmDTOs(films: List<Film>): List<FilmDTO> {
            return films.stream()
                .map { film -> buildFilmDTO(film) }
                .collect(Collectors.toList())
        }


        fun buildFilmDTO(film: Film): FilmDTO {
            return FilmDTO(
                filmId = film.filmId,
                title = film.title,
                description = film.description,
                releaseYear = film.releaseYear,
                language = film.language.name,
                rentalDuration = film.rentalDuration,
                rentalRate = film.rentalRate,
                actors = extractActors(film),
                categories = extractCategories(film)
            )
        }

        private fun extractCategories(film: Film): MutableList<String> {
            val categories = mutableListOf<String>()
            for (category in film.categories) {
                categories.add(category.name);
            }
            return categories
        }

        private fun extractActors(film: Film): MutableList<String> {
            val actors = mutableListOf<String>()
            for (actor in film.actors) {
                actors.add(actor.firstName + " " + actor.lastName);
            }
            return actors;
        }
    }
}