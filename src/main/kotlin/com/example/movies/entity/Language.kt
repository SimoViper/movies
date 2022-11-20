package com.example.movies.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Language (
    @Id var languageId: Long,
    var name: String,
    var lastUpdate: Date
    )