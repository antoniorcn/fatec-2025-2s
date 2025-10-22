package edu.curso.agenda.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.security.Key
import java.util.Date

class JwtUtils {

    private val SECRET_KEY: String = "3h23hkjh5kh4lkh324lk5h23k5h2k45h2lkj43hk32h5lkj32h45lk23h45k2h34lk5h324lkj5h32kj45h32kj45h325lk3245"

    fun getSignKey() : Key {
        val base64 = Decoders.BASE64.decode(SECRET_KEY )
        return Keys.hmacShaKeyFor(base64 )
    }

    fun createToken(email : String, perfil : String) : String {
        val expireDate = Date( System.currentTimeMillis() + (3 * 60 * 60 * 1000))
        val claims = HashMap<String, Any>()
        claims.put("perfil", perfil)
        return Jwts.builder()
            .issuedAt(Date())
            .expiration(expireDate)
            .subject( email )
            .claims( claims )
            .signWith(getSignKey() )
            .compact()
    }
}