package com.conway.basicspringbootwebkotlin.service

import org.springframework.stereotype.Service

/** Created by Conway */
@Service
class HelloService {
    fun hello(): String {
        return "hello"
    }
}