package com.conway.basicspringbootwebkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/** Created by Conway */
@SpringBootApplication class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
