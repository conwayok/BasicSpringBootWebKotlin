package com.conway.basicspringbootwebkotlin.dao

import com.conway.basicspringbootwebkotlin.model.entity.HelloModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

/** Created by Conway */
// use application-test.yaml
@ActiveProfiles(value = ["test"])
@DataJpaTest
internal open class HelloDaoTest {

    @Autowired
    private lateinit var helloDao: HelloDao

    private val logger = LoggerFactory.getLogger(HelloDaoTest::class.java)

    @Test
    fun testSave() {
        val helloModel = HelloModel(col1 = "asdf", col2 = "qwer")
        val result = helloDao.save(helloModel)
        Assertions.assertNotNull(result)
    }

    @Test
    fun findAll() {
        val helloModel = HelloModel(col1 = "1234", col2 = "5678")
        helloDao.save(helloModel)
        val helloModels = helloDao.findAll()
        logger.info(helloModels.toString())
        Assertions.assertTrue(helloModels.isNotEmpty())
    }
}