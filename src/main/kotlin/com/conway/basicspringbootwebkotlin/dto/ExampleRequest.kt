package com.conway.basicspringbootwebkotlin.dto

import io.swagger.v3.oas.annotations.media.Schema

/** Created by Conway */
@Schema(title = "request body")
data class ExampleRequest(
  @get:Schema(title = "firstWord", description = "the first word", example = "Aloha")
  val firstWord: String,
  @get:Schema(title = "secondWord", description = "the second word", example = "World")
  val secondWord: String
)