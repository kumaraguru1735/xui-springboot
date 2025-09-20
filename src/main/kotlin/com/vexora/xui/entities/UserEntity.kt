package com.vexora.xui.entities

import jakarta.persistence.*
import jakarta.validation.constraints.*
import java.io.Serializable

@Entity
@Table(name = "users")
open class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Int = 0,

    @Column(name = "username", length = 50)
    @field:NotBlank(message = "Username is required")
    @field:Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    open var username: String? = null,

    @Column(name = "password", length = 255)
    @field:NotBlank(message = "Password is required")
    @field:Size(min = 6, message = "Password must be at least 6 characters")
    open var password: String? = null,

    @Column(name = "email", length = 255)
    @field:Email(message = "Invalid email format")
    open var email: String? = null,

    @Column(name = "ip", length = 255)
    open var ip: String? = null,

    @Column(name = "date_registered")
    open var dateRegistered: Int? = null,

    @Column(name = "last_login")
    open var lastLogin: Int? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_group_id")
    @field:NotNull(message = "Member group is required")
    open var groupId: UserGroupEntity? = null,

    @Column(name = "credits")
    @field:Min(value = 0, message = "Credits cannot be negative")
    open var credits: Float = 0f,

    @Lob
    @Column(name = "notes", columnDefinition = "MEDIUMTEXT")
    open var notes: String? = null,

    @Column(name = "status")
    open var status: Int = 1,

    @Lob
    @Column(name = "reseller_dns", columnDefinition = "MEDIUMTEXT")
    open var resellerDns: String? = null,

    @Column(name = "owner_id")
    open var ownerId: Int = 0,

    @Lob
    @Column(name = "override_packages", columnDefinition = "TEXT")
    open var overridePackages: String? = null,

    @Column(name = "hue")
    open var hue: String? = null,

    @Column(name = "theme")
    open var theme: Int = 0,

    @Column(name = "timezone")
    open var timezone: String? = null,

    @Column(name = "api_key", length = 64)
    open var apiKey: String? = null

) : Serializable