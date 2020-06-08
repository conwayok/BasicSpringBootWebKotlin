package com.conway.basicspringbootwebkotlin.controller

import com.conway.basicspringbootwebkotlin.dto.CustomResponse
import com.conway.basicspringbootwebkotlin.dto.ExamplePayload
import com.conway.basicspringbootwebkotlin.dto.ExampleRequest
import com.conway.basicspringbootwebkotlin.service.HelloService
import com.conway.basicspringbootwebkotlin.util.CustomResponseUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/** Created by Conway */
@RestController
@RequestMapping("/Hello")
class HelloController @Autowired constructor(private val helloService: HelloService) {

  private val logger: Logger = LoggerFactory.getLogger(HelloController::class.java)

  /**
   * 最基本get
   */
  @GetMapping(value = ["/Hello"])
  fun hello(): ResponseEntity<String> {
    logger.info("hello")
    val str = helloService.hello()
    return ResponseEntity.status(HttpStatus.OK).body(str)
  }

  /**
   * 回傳自訂response
   */
  @GetMapping(value = ["/Custom"])
  fun helloCustomResponse(): ResponseEntity<CustomResponse<Any>> {
    logger.info("helloCustomResponse")
    val response = helloService.helloCustomResponse()
    return CustomResponseUtil.toResponseEntity(response)
  }

  @PostMapping(value = ["/Data/Save"])
  fun saveData(
    @RequestBody
    exampleRequest: ExampleRequest
  ): ResponseEntity<CustomResponse<ExamplePayload>> {
    logger.info("post $exampleRequest")
    val customResponse = helloService.saveData(exampleRequest)
    return CustomResponseUtil.toResponseEntity(customResponse)
  }

  @GetMapping(value = ["/Data/Get"])
  fun getData(
    @RequestParam("Id")
    id: Long
  ): ResponseEntity<CustomResponse<ExamplePayload>> {
    logger.info("getData $id")
    val customResponse = helloService.getData(id)
    return CustomResponseUtil.toResponseEntity(customResponse)
  }
}