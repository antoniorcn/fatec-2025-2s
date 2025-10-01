package edu.curso.agenda.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {


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

        return http.build()
    }
}