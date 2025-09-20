package com.vexora.xui.repository

import com.vexora.xui.entities.UserGroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserGroupRepository : JpaRepository<UserGroupEntity, Int>{
    fun findById(id: UserGroupEntity): UserGroupEntity?

}