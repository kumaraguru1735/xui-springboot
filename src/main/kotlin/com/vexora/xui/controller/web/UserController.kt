package com.vexora.xui.controller.web

import com.vexora.xui.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import kotlin.jvm.java

@Controller
class UserController {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/login")
    fun loginPage(
        model: Model,
        @RequestParam(value = "error", required = false) error: String?,
        @RequestParam(value = "logout", required = false) logout: String?
    ): String {
        logger.debug("Accessing login page")
        model.addAttribute("title", "XUI | Login")
        if (error != null) {
            model.addAttribute("error", "Invalid username or password")
        }
        if (logout != null) {
            model.addAttribute("success", "You have been logged out successfully")
        }
        return "login"
    }
}