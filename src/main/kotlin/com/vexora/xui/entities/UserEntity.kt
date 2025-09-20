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

    @Column(name = "username", length = 50, unique = true)
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
    @JoinColumn(name = "member_group_id", nullable = false)
    @field:NotNull(message = "Member group is required")
    open var groupId: UserGroupEntity? = null,

    @Column(name = "credits", nullable = false)
    @field:DecimalMin(value = "0.0", message = "Credits cannot be negative")
    open var credits: Float = 0f,

    @Lob
    @Column(name = "notes", columnDefinition = "MEDIUMTEXT")
    open var notes: String? = null,

    @Column(name = "status", nullable = false)
    open var status: Int = 1,

    @Lob
    @Column(name = "reseller_dns", columnDefinition = "MEDIUMTEXT")
    open var resellerDns: String? = null,

    @Column(name = "owner_id")
    open var ownerId: Int? = null, // Changed default from 1 to null

    @Lob
    @Column(name = "override_packages", columnDefinition = "TEXT")
    open var overridePackages: String? = null,

    @Column(name = "hue")
    open var hue: String? = null,

    @Column(name = "theme", nullable = false)
    open var theme: Int = 0,

    @Column(name = "timezone")
    open var timezone: String? = null,

    @Column(name = "api_key", length = 64, unique = true)
    open var apiKey: String? = null

) : Serializable {

    override fun toString(): String {
        return "UserEntity(id=$id, username='$username', email='$email')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserEntity) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}