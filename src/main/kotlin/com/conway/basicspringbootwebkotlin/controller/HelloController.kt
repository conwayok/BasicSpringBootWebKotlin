package com.conway.basicspringbootwebkotlin.controller

import com.conway.basicspringbootwebkotlin.service.HelloService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/** Created by Conway */
@RestController
@RequestMapping("/Hello")
class HelloController @Autowired constructor(private val helloService: HelloService) {

    private val logger: Logger = LogManager.getLogger(HelloController::class.java)

    @GetMapping("/Hello")
    fun hello(): ResponseEntity<String> {
        logger.info("hello")
        val str = helloService.hello();
        return ResponseEntity.status(HttpStatus.OK).body(str)
    }
}