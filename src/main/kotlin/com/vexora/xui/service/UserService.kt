package com.vexora.xui.service

import com.vexora.xui.repository.UserGroupRepository
import com.vexora.xui.repository.UserRepository
import com.vexora.xui.entities.UserEntity
import com.vexora.xui.entities.UserGroupEntity
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userGroupRepository: UserGroupRepository
) {

    fun addUser(user: UserEntity) {
        // Set default values if needed
        user.dateRegistered = Instant.now().epochSecond.toInt()
        user.status = 1 // Default status: active
        userRepository.save(user)
    }

    fun findByUsername(username: String): UserEntity? {
        return userRepository.findByUsername(username)
    }

    fun getAllGroups(): List<UserGroupEntity> {
        return userGroupRepository.findAll()
    }

    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }
}
