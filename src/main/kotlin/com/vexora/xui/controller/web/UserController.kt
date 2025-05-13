package com.vexora.xui.controller.web

import com.vexora.xui.entities.UserEntity
import com.vexora.xui.repository.UserRepository
import com.vexora.xui.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import kotlin.jvm.java

@Controller
class UserController(
    private val userService: UserService,
) {
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
    @GetMapping("/user")
    fun showAddUserForm(model: Model): String {
        model.addAttribute("title", "XUI | User")
        model.addAttribute("user", UserEntity())
        model.addAttribute("users", userService.getAllUsers())
        model.addAttribute("groups", userService.getAllGroups())
        return "user" // This refers to `user.html` in `resources/templates`
    }

    @PostMapping("/user/add")
    fun addUser(@ModelAttribute user: UserEntity): String {
        userService.addUser(user)
        return "redirect:/dashboard" // Or another page after user creation
    }

    @GetMapping("/users")
    fun users(model: Model): String {
        model.addAttribute("title", "XUI | Users")
        return "users"
    }
}