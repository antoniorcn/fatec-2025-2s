package edu.curso.agenda.security

import edu.curso.agenda.controller.UsuarioController
import edu.curso.agenda.service.UsuarioService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(
    private val usuarioService: UsuarioService
) : OncePerRequestFilter() {
    val logger : Logger = LoggerFactory.getLogger(JwtAuthFilter::class.java)
    val jwtUtils : JwtUtils = JwtUtils()
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        logger.info("JwtAuthFilter:doFilterInternal() - acionado")
        logger.info("Logging in as ${request.method} ${request.requestURI}")
        // Authorization: <Texto do Authorization>
        request.getHeader(HttpHeaders.AUTHORIZATION)?.let {
            val token = it.substringAfter("Bearer ")
            logger.info("Token: $token")
            val username = jwtUtils.validateToken( token )
            logger.info("Username: $username")
            if (username != null) {
                val userDB = usuarioService.consultarPorEmail(username)
                logger.info("UserDB: $userDB")
                if( userDB != null ) {
                    val userDetails = UserDetailsImplementation( userDB )
                    val userToken = UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.authorities
                    )
                    userToken.details = WebAuthenticationDetailsSource()
                        .buildDetails( request )
                    SecurityContextHolder.getContext().authentication = userToken
                }
            }
        }
        filterChain.doFilter(request, response)
    }
}