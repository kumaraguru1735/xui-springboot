package com.vexora.xui.config

import com.vexora.xui.service.CustomUserDetailsService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    @param:Value("\${security.remember-me.key}") private val rememberMeKey: String
) {
    private val logger = LoggerFactory.getLogger(SecurityConfig::class.java)

    @Bean
    fun authenticationProvider(userDetailsService: CustomUserDetailsService): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        logger.info("Creating BCryptPasswordEncoder bean")
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        logger.info("Configuring security filter chain")

        http {
            httpBasic { disable() }
            csrf { disable() }

            authorizeHttpRequests {
                authorize("/login", permitAll)
                authorize("/assets/**", permitAll)
                authorize(anyRequest, authenticated)
            }

            formLogin {
                loginPage = "/login" // Ensure you have a /login endpoint or view
                loginProcessingUrl = "/login"
                defaultSuccessUrl("/dashboard", true)
                failureUrl = "/login?error=true"
                permitAll()
            }

            rememberMe {
                key = rememberMeKey
                tokenValiditySeconds = 86400 // 1 day
                alwaysRemember = true
                useSecureCookie = true
            }

            logout {
                logoutUrl = "/logout"
                logoutSuccessUrl = "/login?logout=true"
                invalidateHttpSession = true
                deleteCookies("JSESSIONID")
                permitAll()
            }

            sessionManagement {
                sessionConcurrency {
                    maximumSessions = 1
                    maxSessionsPreventsLogin = false
                }
            }

            exceptionHandling {
                accessDeniedPage = "/access-denied"
            }
        }

        return http.build()
    }
}