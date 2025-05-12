package com.vexora.xui.repository

import com.vexora.xui.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Int> {
    fun findByEmail(email: String): UserEntity?
    fun findByUsername(username: String): UserEntity?
}