package com.vexora.xui.service

import com.vexora.xui.entities.UserEntity
import com.vexora.xui.entities.UserGroupEntity
import com.vexora.xui.repository.UserGroupRepository
import com.vexora.xui.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun addUser(user: UserEntity) {
        user.password = passwordEncoder.encode(user.password)
        user.dateRegistered = (Instant.now().epochSecond).toInt()
        userRepository.save(user)
    }

    fun findByUsername(username: String): UserEntity? {
        return userRepository.findByUsername(username)
    }

    fun findById(id: Int): UserEntity? {
        return userRepository.findById(id).orElse(null)
    }

    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun searchUsers(term: String?, page: Int, size: Int = 100): List<UserEntity> {
        return if (term.isNullOrBlank()) {
            userRepository.findAll().take(size)
        } else {
            userRepository.findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(term, term)
                .take(size)
        }
    }

    fun getTotalUsers(term: String?): Long {
        return if (term.isNullOrBlank()) {
            userRepository.count()
        } else {
            userRepository.countByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(term, term)
        }
    }

    fun deleteUser(id: Int) {
        userRepository.deleteById(id)
    }

    fun updateUser(user: UserEntity) {
        userRepository.save(user)
    }
}