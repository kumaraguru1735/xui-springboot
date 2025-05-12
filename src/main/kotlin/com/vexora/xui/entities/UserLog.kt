package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "users_logs")
data class UserLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var owner: Int? = null,

    var type: String? = null,

    var action: String? = null,

    @Column(name = "log_id")
    var logId: Int? = null,

    @Column(name = "package_id")
    var packageId: Int? = null,

    var cost: Int? = null,

    @Column(name = "credits_after")
    var creditsAfter: Int? = null,

    var date: Long? = null, // assuming UNIX timestamp

    @Lob
    @Column(name = "deleted_info", columnDefinition = "LONGTEXT")
    var deletedInfo: String? = null
)
