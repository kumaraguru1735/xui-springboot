package com.vexora.xui.controller.web

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CustomErrorController : ErrorController {

    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest, model: Model): String {
        val statusCode = request.getAttribute("jakarta.servlet.error.status_code") as? Int
        val errorMessage = request.getAttribute("jakarta.servlet.error.message") as? String
        val path = request.getAttribute("jakarta.servlet.error.request_uri") as? String

        model.addAttribute("status", statusCode ?: 500)
        model.addAttribute("error", errorMessage ?: "Unexpected error")
        model.addAttribute("path", path ?: "N/A")

        return when (statusCode) {
            404 -> "error/404"
            else -> "error/500"
        }
    }

}