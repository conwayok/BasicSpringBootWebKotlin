package com.conway.basicspringbootwebkotlin.dto

/** Created by Conway */
data class CustomResponse<T>(val code: Int, val message: String, var payload: T? = null)