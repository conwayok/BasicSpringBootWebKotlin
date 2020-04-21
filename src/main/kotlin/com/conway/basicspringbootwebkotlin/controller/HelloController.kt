package com.conway.basicspringbootwebkotlin.controller

import com.conway.basicspringbootwebkotlin.model.CustomResponse
import com.conway.basicspringbootwebkotlin.model.view.AlohaViewModel
import com.conway.basicspringbootwebkotlin.model.view.HelloViewModel
import com.conway.basicspringbootwebkotlin.service.HelloService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/** Created by Conway */
@RestController
@RequestMapping("/Hello")
class HelloController @Autowired constructor(private val helloService: HelloService) {

    private val logger: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping(value = ["/Hello"])
    fun hello(): ResponseEntity<String> {
        logger.info("hello")
        val str = helloService.hello();
        return ResponseEntity.status(HttpStatus.OK).body(str)
    }

    @PostMapping(value = ["/Hello2"])
    fun hello2(@RequestBody alohaViewModel: AlohaViewModel): ResponseEntity<CustomResponse<HelloViewModel>> {
        logger.info("hello2 $alohaViewModel")
        val customResponse = helloService.hello2(alohaViewModel)
        return ResponseEntity.status(HttpStatus.OK).body(customResponse)
    }
}