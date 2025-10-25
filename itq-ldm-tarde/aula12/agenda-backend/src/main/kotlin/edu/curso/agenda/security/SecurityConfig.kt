package edu.curso.agenda.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(val jwtAuthFilter : JwtAuthFilter) {

    @Bean
    fun getEncoder() : PasswordEncoder =
        BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http : HttpSecurity) : SecurityFilterChain {
        http
            .csrf {
                it.disable()
            }
            .sessionManagement {
                it.disable()
            }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtAuthFilter,
                UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }
}