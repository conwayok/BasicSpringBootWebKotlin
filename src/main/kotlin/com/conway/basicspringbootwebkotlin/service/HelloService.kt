package com.conway.basicspringbootwebkotlin.service

import com.conway.basicspringbootwebkotlin.dao.HelloDao
import com.conway.basicspringbootwebkotlin.model.CustomResponse
import com.conway.basicspringbootwebkotlin.model.entity.HelloModel
import com.conway.basicspringbootwebkotlin.model.view.AlohaViewModel
import com.conway.basicspringbootwebkotlin.model.view.HelloViewModel
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

    fun hello2(alohaViewModel: AlohaViewModel): CustomResponse<HelloViewModel> {
        logger.info(alohaViewModel.toString())
        val firstWord = alohaViewModel.firstWord
        val secondWord = alohaViewModel.secondWord
        val helloModel = HelloModel(col1 = firstWord, col2 = secondWord)
        helloDao.save(helloModel)
        return CustomResponse(1, "success", HelloViewModel(data1 = firstWord, data2 = secondWord))
    }
}