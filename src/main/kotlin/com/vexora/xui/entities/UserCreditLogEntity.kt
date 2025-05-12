package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users_credits_logs")
data class UserCreditLogEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "target_id")
    var targetId: Int? = null,

    @Column(name = "admin_id")
    var adminId: Int? = null,

    var amount: Float? = null,

    var date: Int? = null,

    @Column(columnDefinition = "MEDIUMTEXT")
    var reason: String? = null
)
