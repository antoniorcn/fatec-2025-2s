package edu.curso.agenda.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    val jwtAuthFilter : JwtAuthFilter
) {

    @Bean
    fun getPasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }


    @Bean
    fun securityFilterChainBuilder(http: HttpSecurity) : SecurityFilterChain {

        http
            .csrf {
                it.disable()
            }
            .authorizeHttpRequests {
                auth ->
                    auth.requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/contato").authenticated()
            }
            .sessionManagement {
                it.disable()
            }
            .addFilterBefore( jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter::class.java )

        return http.build()
    }
}