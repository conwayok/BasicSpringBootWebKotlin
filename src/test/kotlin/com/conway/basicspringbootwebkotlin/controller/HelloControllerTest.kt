package com.conway.basicspringbootwebkotlin.controller

import com.conway.basicspringbootwebkotlin.model.view.AlohaViewModel
import com.conway.basicspringbootwebkotlin.util.ProjectUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

/**
 * Created by Conway
 */
@ActiveProfiles(value = ["test"])
@SpringBootTest
@AutoConfigureMockMvc
internal class HelloControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val logger = LoggerFactory.getLogger(HelloControllerTest::class.java)

    @Test
    fun hello2() {
        val alohaViewModel = AlohaViewModel("aloha", "world")
        val response = mockMvc.perform(
            MockMvcRequestBuilders.post("/Hello/Hello2")
                .content(ProjectUtils.OBJECT_MAPPER.writeValueAsString(alohaViewModel))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andReturn().response
        logger.info(response.contentAsString)
        Assertions.assertEquals(200, response.status)
    }
}