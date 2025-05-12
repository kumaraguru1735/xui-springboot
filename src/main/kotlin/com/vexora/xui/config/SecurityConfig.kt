package com.vexora.xui.config

import com.vexora.xui.service.CustomUserDetailsService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
    private val logger = LoggerFactory.getLogger(SecurityConfig::class.java)

//    @Bean
//    fun userDetailsService(pass: PasswordEncoder): UserDetailsService {
//        val user = User.withUsername("user")
//            .password(pass.encode("user123"))
//            .roles("USER")
//            .build()
//        val admin = User.withUsername("admin@railwire.com")
//            .password(pass.encode("admin@123"))
//            .roles("ADMIN")
//            .build()
//        return InMemoryUserDetailsManager(user, admin)
//    }

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