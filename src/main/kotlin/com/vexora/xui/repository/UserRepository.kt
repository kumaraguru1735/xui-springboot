package com.vexora.xui.repository

import com.vexora.xui.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?
}