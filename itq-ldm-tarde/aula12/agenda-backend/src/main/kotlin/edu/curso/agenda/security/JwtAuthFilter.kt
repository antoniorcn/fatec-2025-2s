package edu.curso.agenda.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(
    val tokenService : TokenService,
    val userDetailService : UserDetailsService
) : OncePerRequestFilter() {

    private val logger = LoggerFactory.getLogger(JwtAuthFilter::class.java)

    override fun doFilterInternal(
        request : HttpServletRequest, response : HttpServletResponse,
        filterChain : FilterChain
    ) {
        logger.info("Http Context Path: ${request.contextPath}")
        logger.info("Http Servlet Path: ${request.servletPath}")
        logger.info("Http Headers: ${request.headerNames}")

        val authHeader = request.getHeader("Authorization")
        var authenticado = false
        if (authHeader != null && authHeader.contains("Bearer")) {
            val token = authHeader.substring(7)
            val username = tokenService.extractUsername( token )
            val expired = tokenService.isTokenExpired( token )
            if ( !expired ) {
                val userDetails = userDetailService.loadUserByUsername( username )
                if ( userDetails != null ) {
                    val authToken = UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.authorities )
                    SecurityContextHolder.getContext().authentication = authToken
                    authenticado = true
                }
            }
        }
//        if (!authenticado) {
//            // throw Exception("Erro na auhtenticação")
//            response.sendError(401, "Erro na autenticação")
//        }
        filterChain.doFilter( request, response )
    }



}