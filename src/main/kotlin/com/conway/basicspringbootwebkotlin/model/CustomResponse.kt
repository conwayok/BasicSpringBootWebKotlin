package com.conway.basicspringbootwebkotlin.model

/** Created by Conway */
data class CustomResponse<T>(val code: Int, val message: String, val data: T)