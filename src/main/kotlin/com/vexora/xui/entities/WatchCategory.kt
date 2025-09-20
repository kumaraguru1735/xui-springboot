package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "watch_categories")
open class WatchCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long = 0,

    @Column(name = "type")
    open var type: Int = 0,

    @Column(name = "genre_id")
    open var genreId: Int = 0,

    @Column(name = "genre")
    open var genre: String? = null,

    @Column(name = "category_id")
    open var categoryId: Int = 0,

    @Column(name = "bouquets")
    open var bouquets: String? = null

) : Serializable

