package com.vexora.xui.controller.web

import com.vexora.xui.entities.UserEntity
import com.vexora.xui.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder

@Controller
class UserController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder // Inject PasswordEncoder for secure password storage
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
        model.addAttribute("user", UserEntity()) // Empty user for form binding
        model.addAttribute("users", userService.getAllUsers())
        model.addAttribute("groups", userService.getAllGroups())
        return "user" // Maps to user.html
    }

    @PostMapping("/user/add")
    fun addUser(
        @Valid @ModelAttribute user: UserEntity,
        bindingResult: BindingResult,
        redirectAttributes: RedirectAttributes
    ): String {
        if (bindingResult.hasErrors()) {
            // Log validation errors and return to the form with errors
            logger.warn("Validation errors while adding user: {}", bindingResult.allErrors)
            redirectAttributes.addFlashAttribute("error", "Please correct the errors in the form")
            return "redirect:/user"
        }

        try {
            // Check if username already exists
            if (userService.findByUsername(user.username!!) != null) {
                redirectAttributes.addFlashAttribute("error", "Username already exists")
                return "redirect:/user"
            }

            // Encode password before saving
            user.password = passwordEncoder.encode(user.password)
            userService.addUser(user)
            redirectAttributes.addFlashAttribute("success", "User added successfully")
            return "redirect:/users"
        } catch (e: Exception) {
            logger.error("Error adding user", e)
            redirectAttributes.addFlashAttribute("error", "An error occurred while adding the user")
            return "redirect:/user"
        }
    }

    @GetMapping("/users")
    fun users(model: Model): String {
        model.addAttribute("title", "XUI | Users")
        model.addAttribute("users", userService.getAllUsers())
        return "users"
    }
}