package edu.curso.agenda.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Base64
import java.util.Date
import javax.crypto.spec.SecretKeySpec

@Service
class TokenService(
    @Value("\${jwt.secret}") private val secret: String = ""
) {
    private val logger = LoggerFactory.getLogger(TokenService::class.java)
    private val signingKey: SecretKeySpec
        get() {
            val keyBytes: ByteArray = Base64.getDecoder().decode(secret)
            return SecretKeySpec(keyBytes, 0, keyBytes.size, "HmacSHA256")
        }

    fun generateToken(subject: String, expiration: Date, additionalClaims: Map<String, Any> = emptyMap()): String {
        logger.info("JwT Secret ==> $secret")
        return Jwts.builder()
            .setClaims(additionalClaims)
            .setSubject(subject)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(expiration)
            .signWith(signingKey)
            .compact()
    }

    fun extractUsername(token: String): String {
        return extractAllClaims(token).subject
    }

    fun isTokenExpired(token: String): Boolean {
        val expiration: Date = getClaimFromToken(token, Claims::getExpiration)
        return expiration.before(Date())
    }

    fun <T> getClaimFromToken(token: String, claimsResolver: (Claims) -> T): T {
        val claims: Claims = extractAllClaims(token)
        return claimsResolver(claims)
    }


    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(signingKey)
            .build()
            .parseClaimsJws(token)
            .body
    }
}