package com.vexora.xui.service
import com.vexora.xui.entities.UserGroupEntity
import com.vexora.xui.repository.UserGroupRepository
import org.springframework.stereotype.Service


@Service
class UserGroupService(
    val userGroupRepository: UserGroupRepository
) {
    fun getUserGroup(id: UserGroupEntity) = userGroupRepository.findById(id)

    fun findGroupById(id: Int): UserGroupEntity? {
        return userGroupRepository.findById(id).orElse(null)
    }

    fun getAllGroups(): List<UserGroupEntity> {
        return userGroupRepository.findAll()
    }
}