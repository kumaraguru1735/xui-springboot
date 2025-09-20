package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.sql.Timestamp

@Entity
@Table(name = "users_subreseller")
open class UserSubreseller(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Long = 0,

    @Column(name = "reseller")
    open var reseller: Int = 0,

    @Column(name = "subreseller")
    open var subreseller: Int = 0,

    @Column(name = "status")
    open var status: Int = 1,

    @Column(name = "dateadded")
    open var dateAdded: Timestamp? = null

) : Serializable