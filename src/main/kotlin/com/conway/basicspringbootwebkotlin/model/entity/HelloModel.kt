package com.conway.basicspringbootwebkotlin.model.entity

import javax.persistence.*

/** Created by Conway */
@Entity
@Table(name = "vHello")
data class HelloModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var key: Long? = null,

    @Column(columnDefinition = "varchar(32)")
    var col1: String? = null,

    @Column(columnDefinition = "varchar(32)")
    var col2: String? = null
)