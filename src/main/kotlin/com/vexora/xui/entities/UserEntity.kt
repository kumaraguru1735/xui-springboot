package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.io.Serializable


@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(length = 50)
    var username: String? = null,

    @Column(length = 255)
    var password: String? = null,

    @Column(length = 255)
    var email: String? = null,

    @Column(length = 255)
    var ip: String? = null,

    @Column(name = "date_registered")
    var dateRegistered: Int? = null,

    @Column(name = "last_login")
    var lastLogin: Int? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_group_id")
    var groupId: UserGroupEntity? = null,

    var credits: Float = 0f,

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    var notes: String? = null,

    var status: Int = 1,

    @Lob
    @Column(name = "reseller_dns", columnDefinition = "MEDIUMTEXT")
    var resellerDns: String? = null,

    @Column(name = "owner_id")
    var ownerId: Int = 0,

    @Column(name = "override_packages", columnDefinition = "TEXT")
    var overridePackages: String? = null,

    var hue: String? = null,

    var theme: Int = 0,

    var timezone: String? = null,

    @Column(name = "api_key", length = 64)
    var apiKey: String? = null
)  : Serializable
