package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "spring_session")
data class SessionEntities(
    @Id
    @Column(name = "primary_id", nullable = false, length = 36)
    val primaryId: String = "",

    @Column(name = "session_id", nullable = false, unique = true, length = 36)
    val sessionId: String = "",

    @Column(name = "creation_time", nullable = false)
    val creationTime: Long = 0L,

    @Column(name = "last_access_time", nullable = false)
    val lastAccessTime: Long = 0L,

    @Column(name = "max_inactive_interval", nullable = false)
    val maxInactiveInterval: Int = 0,

    @Column(name = "expiry_time", nullable = false)
    val expiryTime: Long = 0L,

    @Column(name = "principal_name", length = 100)
    val principalName: String? = null
)