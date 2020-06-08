package com.conway.basicspringbootwebkotlin

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by Conway
 */
@SpringBootTest
internal class ApplicationKtTest {

  private val logger = LoggerFactory.getLogger(ApplicationKtTest::class.java)

  @Test
  fun contextLoads() {
    logger.info("run")
  }
}