package com.vexora.xui.service

import com.vexora.xui.repository.UserGroupRepository
import com.vexora.xui.repository.UserRepository
import com.vexora.xui.entities.UserEntity
import com.vexora.xui.entities.UserGroupEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userGroupRepository: UserGroupRepository
) {

    fun addUser(user: UserEntity): UserEntity {
        return userRepository.save(user)
    }

    fun getAllGroups(): List<UserGroupEntity> {
        return userGroupRepository.findAll()
    }

    fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }
}
