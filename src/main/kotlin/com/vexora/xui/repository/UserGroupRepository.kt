package com.vexora.xui.repository

import com.vexora.xui.entities.UserGroupEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserGroupRepository : JpaRepository<UserGroupEntity, Int>