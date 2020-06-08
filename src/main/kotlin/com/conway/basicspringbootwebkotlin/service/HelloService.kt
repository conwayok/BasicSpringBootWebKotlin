package com.conway.basicspringbootwebkotlin.service

import com.conway.basicspringbootwebkotlin.dao.HelloDao
import com.conway.basicspringbootwebkotlin.dto.CustomResponse
import com.conway.basicspringbootwebkotlin.dto.ExamplePayload
import com.conway.basicspringbootwebkotlin.dto.ExampleRequest
import com.conway.basicspringbootwebkotlin.entity.HelloModel
import com.conway.basicspringbootwebkotlin.util.CustomResponseUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/** Created by Conway */
@Service
class HelloService @Autowired constructor(private val helloDao: HelloDao) {

  private val logger = LoggerFactory.getLogger(HelloService::class.java)

  fun hello(): String {
    return "hello"
  }

  fun helloCustomResponse(): CustomResponse<Any> {
    return CustomResponseUtil.ok()
  }

  fun saveData(exampleRequest: ExampleRequest): CustomResponse<ExamplePayload> {
    logger.info(exampleRequest.toString())
    val firstWord = exampleRequest.firstWord
    val secondWord = exampleRequest.secondWord
    val helloModel = HelloModel(col1 = firstWord, col2 = secondWord)
    helloDao.save(helloModel)
    return CustomResponse(
      1, "success",
      ExamplePayload(
        data1 = firstWord,
        data2 = secondWord
      )
    )
  }

  fun getData(id: Long): CustomResponse<ExamplePayload> {
    logger.info("getData $id")
    val helloModelOptional = helloDao.findById(id)
    return if (helloModelOptional.isPresent) {
      val helloModel = helloModelOptional.get()
      val payload = ExamplePayload(helloModel.col1, helloModel.col2)
      CustomResponseUtil.ok(payload)
    } else {
      CustomResponseUtil.nonExistentDataError()
    }
  }
}