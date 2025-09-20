package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "users_credits_logs")
open class UserCreditLogEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Int = 0,

    @Column(name = "target_id")
    open var targetId: Int? = null,

    @Column(name = "admin_id")
    open var adminId: Int? = null,

    @Column(name = "amount")
    open var amount: Float? = null,

    @Column(name = "date")
    open var date: Int? = null,

    @Lob
    @Column(name = "reason", columnDefinition = "MEDIUMTEXT")
    open var reason: String? = null

) : Serializable