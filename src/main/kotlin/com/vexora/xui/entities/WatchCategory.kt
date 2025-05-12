package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "watch_categories")
data class WatchCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var type: Int = 0,
    @Column(name = "genre_id")
    var genreId: Int = 0,
    var genre: String? = null,
    @Column(name = "category_id")
    var categoryId: Int = 0,
    var bouquets: String? = null
)
