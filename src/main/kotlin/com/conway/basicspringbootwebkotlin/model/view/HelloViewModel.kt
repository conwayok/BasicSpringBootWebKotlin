package com.conway.basicspringbootwebkotlin.model.view

import io.swagger.v3.oas.annotations.media.Schema

/** Created by Conway */
@Schema(title = "HelloViewModel response body")
data class HelloViewModel(
    @get:Schema(title = "data1 title")
    val data1: String,
    @get:Schema(title = "data2 title")
    val data2: String
)