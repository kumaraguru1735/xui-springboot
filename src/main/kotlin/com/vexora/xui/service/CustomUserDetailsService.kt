package com.vexora.xui.service

import com.vexora.xui.controller.web.UserController
import com.vexora.xui.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.DisabledException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService, Serializable {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    override fun loadUserByUsername(username: String): UserDetails? {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found: $username")
        logger.debug("Loaded user: $username, Status: ${user.status}, Password: ${user.password}")
        if (user.status != 1) {
            throw DisabledException("User account is disabled.")
        }

        val role = when {
            user.groupId?.isAdmin == true -> "ROLE_ADMIN"
            user.groupId?.isReseller == true -> "ROLE_RESELLER"
            else -> "ROLE_USER"
        }
        val authorities = listOf(SimpleGrantedAuthority(role))
        return User(user.username, user.password, authorities)
    }
}