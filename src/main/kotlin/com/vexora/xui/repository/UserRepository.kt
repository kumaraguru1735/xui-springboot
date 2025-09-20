package com.vexora.xui.repository

import com.vexora.xui.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity?

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :term, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', :term, '%'))")
    fun findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(term: String, term2: String): List<UserEntity>

    @Query("SELECT COUNT(u) FROM UserEntity u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :term, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', :term, '%'))")
    fun countByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(term: String, term2: String): Long
}