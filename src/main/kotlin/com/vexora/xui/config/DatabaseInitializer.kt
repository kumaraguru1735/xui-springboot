package com.vexora.xui.config

import com.vexora.xui.entities.UserEntity
import com.vexora.xui.entities.UserGroupEntity
import com.vexora.xui.repository.UserGroupRepository
import com.vexora.xui.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class DatabaseInitializer {

    @Bean
    fun initUserGroups(
        userRepository: UserRepository,
        passwordEncoder: PasswordEncoder,
        userGroupRepository: UserGroupRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            if (userGroupRepository.count() == 0L) {
                userGroupRepository.saveAll(
                    listOf(
                        UserGroupEntity(
                            id = 1,
                            groupName = "Administrators",
                            isAdmin = true,
                            isReseller = false,
                            totalAllowedGenTrials = 0,
                            totalAllowedGenIn = "day",
                            deleteUsers = false,
                            allowedPages = "[]",
                            canDelete = false,
                            createSubResellers = false,
                            createSubResellersPrice = 0,
                            resellerClientConnectionLogs = false,
                            canViewVod = false,
                            allowDownload = true,
                            minimumTrialCredits = 0,
                            allowRestrictions = false,
                            allowChangeUsername = true,
                            allowChangePassword = true,
                            minimumUsernameLength = 8,
                            minimumPasswordLength = 8,
                            allowChangeBouquets = true
                        ),
                        UserGroupEntity(
                            id = 2,
                            groupName = "Resellers",
                            isAdmin = false,
                            isReseller = true,
                            totalAllowedGenTrials = 100000,
                            totalAllowedGenIn = "month",
                            deleteUsers = true,
                            allowedPages = "[]",
                            canDelete = false,
                            createSubResellers = false,
                            createSubResellersPrice = 0,
                            resellerClientConnectionLogs = true,
                            canViewVod = true,
                            allowDownload = true,
                            minimumTrialCredits = 0,
                            allowRestrictions = true,
                            allowChangeUsername = true,
                            allowChangePassword = true,
                            minimumUsernameLength = 8,
                            minimumPasswordLength = 8,
                            allowChangeBouquets = true
                        )
                    )
                )
            }
            if (userRepository.count() == 0L) {
                val adminGroup = userGroupRepository.findById(1).orElseThrow {
                    IllegalStateException("Admin group must exist before inserting user.")
                }

                userRepository.save(
                    UserEntity(
                        username = "admin",
                        password = passwordEncoder.encode("admin"),
                        email = "admin@gmail.com",
                        ip = "127.0.0.1",
                        dateRegistered = 1738152821,
                        lastLogin = 1746900140,
                        groupId = adminGroup,
                        credits = 0f,
                        notes = null,
                        status = 1,
                        resellerDns = null,
                        ownerId = 1,
                        overridePackages = "[]",
                        hue = "",
                        theme = 0,
                        timezone = "",
                        apiKey = ""
                    )
                )
            }
        }
    }

}