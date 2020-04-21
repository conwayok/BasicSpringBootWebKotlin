package com.conway.basicspringbootwebkotlin.model.view

import io.swagger.v3.oas.annotations.media.Schema

/** Created by Conway */
@Schema(title = "AlohaViewModel request body")
data class AlohaViewModel(
    @get:Schema(title = "firstWord", description = "the first word", example = "Aloha")
    val firstWord: String,
    @get:Schema(title = "secondWord", description = "the second word", example = "World")
    val secondWord: String
)