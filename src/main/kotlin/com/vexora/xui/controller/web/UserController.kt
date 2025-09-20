package com.vexora.xui.controller.web

import com.vexora.xui.entities.UserEntity
import com.vexora.xui.service.UserGroupService
import com.vexora.xui.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import jakarta.validation.Valid
import java.security.SecureRandom
import kotlin.random.Random

@Controller
@RequestMapping
class UserController(
    private val userService: UserService,
    private val userGroupService: UserGroupService,
) {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    // Page for user add
    @GetMapping("/user/add")
    fun showAddUserForm(model: Model): String {
        model.addAttribute("title", "XUI | User")
        val user = UserEntity()
        // Auto-generate username and password
        user.username = generateUsername()
        user.password = generatePassword()
        user.credits = 0f // Set default credits
        model.addAttribute("user", user)
        model.addAttribute("users", userService.getAllUsers())
        model.addAttribute("groups", userGroupService.getAllGroups()) // Fixed: use userGroupService
        return "user-add"
    }

    // Page for user list
    @GetMapping("/users/list")
    fun users(model: Model): String {
        model.addAttribute("title", "XUI | Users")
        model.addAttribute("users", userService.getAllUsers())
        return "users"
    }

    // Form submission for adding a user
    @PostMapping("/user/add")
    fun addUser(
        @Valid @ModelAttribute user: UserEntity,
        bindingResult: BindingResult,
        @RequestParam(required = false) creditsReason: String?,
        @RequestParam(required = false) groupId: Int?,
        model: Model,
        redirectAttributes: RedirectAttributes
    ): String {
        // Set the groupId from the request parameter
        if (groupId != null && groupId > 0) {
            val userGroup = userGroupService.findGroupById(groupId)
            user.groupId = userGroup
        }

        if (bindingResult.hasErrors() || user.groupId == null) {
            logger.warn("Validation errors while adding user: {}", bindingResult.allErrors)

            val errorMessage = when {
                user.groupId == null -> "Please select a member group."
                bindingResult.hasFieldErrors("email") -> "Please enter a valid email address."
                bindingResult.hasFieldErrors("username") -> "Please enter a valid username."
                bindingResult.hasFieldErrors("password") -> "Please enter a valid password."
                else -> "Please correct the errors in the form."
            }

            model.addAttribute("error", errorMessage)
            // Re-populate the form data
            model.addAttribute("user", user)
            model.addAttribute("users", userService.getAllUsers())
            model.addAttribute("groups", userGroupService.getAllGroups())
            return "user-add"
        }

        try {
            // Check if username already exists
            if (userService.findByUsername(user.username!!) != null) {
                model.addAttribute("error", "The username you selected already exists. Please use another.")
                model.addAttribute("user", user)
                model.addAttribute("users", userService.getAllUsers())
                model.addAttribute("groups", userGroupService.getAllGroups())
                return "user-add"
            }

            // Group validation is already done above
            val userGroup = user.groupId!!

            // Validate owner if provided
            if (user.ownerId != null && user.ownerId != 0 && userService.findById(user.ownerId!!) == null) {
                model.addAttribute("error", "Please select a valid owner.")
                model.addAttribute("user", user)
                model.addAttribute("users", userService.getAllUsers())
                model.addAttribute("groups", userGroupService.getAllGroups())
                return "user-add"
            }

            // Set default values
            user.dateRegistered = (System.currentTimeMillis() / 1000).toInt()
            user.status = 1

            // Set owner to null if 0 is selected (meaning no owner)
            if (user.ownerId == 0) {
                user.ownerId = null
            }

            // Add user
            userService.addUser(user)

            // Log credits reason if provided
            if (!creditsReason.isNullOrBlank() && user.credits > 0) {
                logger.info("Credits added for user ${user.username}: ${user.credits}. Reason: $creditsReason")
            }

            redirectAttributes.addFlashAttribute("success", "User added successfully.")
            return "redirect:/users/list"
        } catch (e: Exception) {
            logger.error("Error adding user", e)
            model.addAttribute("error", "An error occurred while adding the user: ${e.message}")
            model.addAttribute("user", user)
            model.addAttribute("users", userService.getAllUsers())
            model.addAttribute("groups", userGroupService.getAllGroups())
            return "user-add"
        }
    }

    // API for registered user list (used by select2 for owner_id)
    @GetMapping("/api/reguserlist")
    @ResponseBody
    fun getUserList(
        @RequestParam(required = false) search: String?,
        @RequestParam(required = false, defaultValue = "1") page: Int
    ): Map<String, Any> {
        val size = 100
        val users = userService.searchUsers(search, page, size)
        val totalCount = userService.getTotalUsers(search)
        return mapOf(
            "items" to users.map {
                mapOf(
                    "id" to it.id,
                    "text" to "${it.email ?: "No Email"} (Username: ${it.username})"
                )
            },
            "total_count" to totalCount
        )
    }

    private fun generateUsername(): String {
        val adjectives = listOf("Swift", "Bold", "Bright", "Cool", "Fast", "Smart", "Wild", "Quick", "Brave", "Sharp")
        val nouns = listOf("Tiger", "Eagle", "Wolf", "Fox", "Lion", "Hawk", "Bear", "Shark", "Falcon", "Panther")
        val randomNumber = Random.nextInt(100, 999)
        return "${adjectives.random()}${nouns.random()}$randomNumber"
    }

    private fun generatePassword(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*"
        val random = SecureRandom()
        return (1..12)
            .map { chars[random.nextInt(chars.length)] }
            .joinToString("")
    }

    // API endpoints for generating username and password
    @GetMapping("/api/generate-username")
    @ResponseBody
    fun generateUsernameApi(): String {
        return generateUsername()
    }

    @GetMapping("/api/generate-password")
    @ResponseBody
    fun generatePasswordApi(): String {
        return generatePassword()
    }
}