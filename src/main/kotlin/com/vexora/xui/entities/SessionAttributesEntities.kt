package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "spring_session_attributes")
data class SessionAttributesEntities(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "session_primary_id", nullable = false, length = 36)
    val sessionPrimaryId: String = "",

    @Column(name = "attribute_name", nullable = false, length = 200)
    val attributeName: String = "",

    @Column(name = "attribute_bytes", nullable = false)
    val attributeBytes: ByteArray = byteArrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SessionAttributesEntities) return false

        return id == other.id &&
                sessionPrimaryId == other.sessionPrimaryId &&
                attributeName == other.attributeName &&
                attributeBytes.contentEquals(other.attributeBytes)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + sessionPrimaryId.hashCode()
        result = 31 * result + attributeName.hashCode()
        result = 31 * result + attributeBytes.contentHashCode()
        return result
    }
}

