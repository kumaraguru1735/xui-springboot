package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users_subreseller")
data class UserSubreseller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var reseller: Int = 0,
    var subreseller: Int = 0,
    var status: Int = 1,

    @Column(name = "dateadded")
    var dateAdded: java.sql.Timestamp? = null
)
