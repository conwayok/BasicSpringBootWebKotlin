package com.conway.basicspringbootwebkotlin.service

import com.conway.basicspringbootwebkotlin.dao.HelloDao
import com.conway.basicspringbootwebkotlin.dto.CustomResponse
import com.conway.basicspringbootwebkotlin.dto.ExamplePayload
import com.conway.basicspringbootwebkotlin.dto.ExampleRequest
import com.conway.basicspringbootwebkotlin.entity.HelloModel
import com.conway.basicspringbootwebkotlin.util.CustomResponseUtil
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class HelloServiceTest {

  private lateinit var helloDao: HelloDao

  private lateinit var helloModel: HelloModel

  private lateinit var helloService: HelloService

  @BeforeAll
  fun setupBeforeAll() {
    helloModel = HelloModel(null, "a", "b")
    helloDao = mockk()
    every { helloDao.save(any<HelloModel>()) } returns helloModel
    every { helloDao.findById(any()) } returns Optional.of(helloModel)
    helloService = HelloService(helloDao)
  }

  @Test
  fun hello() {
    assertEquals("hello", helloService.hello())
  }

  @Test
  fun helloCustomResponse() {
    val expectedResponse = CustomResponseUtil.ok<Any>()
    assertEquals(expectedResponse, helloService.helloCustomResponse())
  }

  @Test
  fun saveData() {
    val exampleRequest = ExampleRequest(firstWord = "a", secondWord = "b")
    val expectedResponse =
      CustomResponse(
        1,
        "success",
        ExamplePayload(
          data1 = exampleRequest.firstWord,
          data2 = exampleRequest.secondWord
        )
      )
    assertEquals(expectedResponse, helloService.saveData(exampleRequest))
  }

  @Test
  fun getData() {
    val expectedResponse = CustomResponseUtil.ok(ExamplePayload(helloModel.col1, helloModel.col2))
    assertEquals(expectedResponse, helloService.getData(0))
  }
}