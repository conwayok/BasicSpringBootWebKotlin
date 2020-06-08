package com.conway.basicspringbootwebkotlin.dto

import io.swagger.v3.oas.annotations.media.Schema

/** Created by Conway */
@Schema(title = "example payload")
data class ExamplePayload(
  @get:Schema(title = "data1 title")
  val data1: String,
  @get:Schema(title = "data2 title")
  val data2: String
)