package com.conway.basicspringbootwebkotlin.dao

import com.conway.basicspringbootwebkotlin.model.entity.HelloModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/** Created by Conway */
@Repository
interface HelloDao : JpaRepository<HelloModel, Long>