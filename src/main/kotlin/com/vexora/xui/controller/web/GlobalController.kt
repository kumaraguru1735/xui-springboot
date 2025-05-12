package com.vexora.xui.controller.web

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class GlobalController {

//    @GetMapping("/login")
//    fun login(model: Model): String {
//        model.addAttribute("title", "XUI | Login")
//        return "login"
//    }

    @GetMapping("/dashboard")
    fun dashboard(model: Model): String {
        model.addAttribute("title", "XUI | Dashboard")
        val authentication = SecurityContextHolder.getContext().authentication
        println("Full Dashboard log: $authentication")
        return "dashboard"
    }

    @GetMapping("/user")
    fun user(model: Model): String {
        model.addAttribute("title", "XUI | User")
        return "user"
    }


    @GetMapping("/users")
    fun users(model: Model): String {
        model.addAttribute("title", "XUI | Users")
        return "users"
    }
}