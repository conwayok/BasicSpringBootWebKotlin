package com.conway.basicspringbootwebkotlin.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

/** Created by Conway */
class ProjectUtils {
    companion object {
        val OBJECT_MAPPER = jacksonObjectMapper()
    }
}