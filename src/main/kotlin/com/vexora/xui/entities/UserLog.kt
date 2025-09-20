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
@Table(name = "users_logs")
open class UserLog(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Long = 0,

    @Column(name = "owner")
    open var owner: Int? = null,

    @Column(name = "type")
    open var type: String? = null,

    @Column(name = "action")
    open var action: String? = null,

    @Column(name = "log_id")
    open var logId: Int? = null,

    @Column(name = "package_id")
    open var packageId: Int? = null,

    @Column(name = "cost")
    open var cost: Int? = null,

    @Column(name = "credits_after")
    open var creditsAfter: Int? = null,

    @Column(name = "date")
    open var date: Long? = null, // assuming UNIX timestamp

    @Lob
    @Column(name = "deleted_info", columnDefinition = "LONGTEXT")
    open var deletedInfo: String? = null

) : Serializable