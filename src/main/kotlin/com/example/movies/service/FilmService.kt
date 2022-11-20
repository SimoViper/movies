package com.example.movies.service

import com.example.movies.entity.Actor
import com.example.movies.entity.Category
import com.example.movies.entity.Film
import com.example.movies.model.FilmDTO
import com.example.movies.repository.ActorRepository
import com.example.movies.repository.CategoryRepository
import com.example.movies.repository.FilmRepository
import org.apache.logging.log4j.util.Strings
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class FilmService  @Autowired constructor(
    val filmRepository: FilmRepository,
    val categoryRepository: CategoryRepository,
    val actorRepository: ActorRepository
) {

    fun getFilms(title: String?, category: String?,
                 actorFirstName: String?, actorLastName: String?): List<FilmDTO> {

        if(title != null && title.isNotEmpty()) {
            return getFilmByTitle(title)
        }
        if(category != null && category.isNotEmpty()){
           return getFilmsByCategory(category)
        }

        return getFilmByActor(actorFirstName, actorLastName)
    }

    private fun getFilmByActor(actorFirstName: String?, actorLastName: String?): List<FilmDTO> {

        if(actorFirstName != null && actorFirstName.isNotEmpty() && actorLastName != null && actorLastName.isNotEmpty()){
            val actor: Actor? = actorRepository.findByFirstNameAndLastName(actorFirstName, actorLastName)
            if(actor != null) {
                return FilmConverter.buildActorsFilmDTOs(listOf(actor))
            }
            return emptyList()
        }
        if(actorLastName != null && actorLastName.isNotEmpty()){
           return FilmConverter.buildActorsFilmDTOs(actorRepository.findByLastName(actorLastName))
        }
        if(actorFirstName != null && actorFirstName.isNotEmpty()){
            return FilmConverter.buildActorsFilmDTOs(actorRepository.findByFirstName(actorFirstName))
        }

        return emptyList()
    }

    private fun getFilmByTitle(title: String): List<FilmDTO> {
        val film: Film? = filmRepository.findByTitle(title)

        if(film != null){
            return listOf(FilmConverter.buildFilmDTO(film))
        }

        return emptyList()
    }

    private fun getFilmsByCategory(category: String): List<FilmDTO> {
        val categoryEntity: Category? = categoryRepository.findByName(category)
        if(categoryEntity != null) {
            return FilmConverter.buildFilmDTOs(categoryEntity.films)
        }
        return emptyList()
    }




}