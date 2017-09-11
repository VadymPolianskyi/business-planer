package com.exec.business.config.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.servlet.http.HttpServletResponse
import java.util.Collections.emptyList
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import javax.servlet.http.HttpServletRequest


/**
 * Author: Vadym Polyanski;
 * Date: 11.09.17;
 * Time: 20:03.
 */
class TokenAuthenticationService {


    companion object {

        private val EXPIRATIONTIME: Long = 864000000 // 10 days
        private val SECRET = "ThisIsASecret"
        private val TOKEN_PREFIX = "Bearer"
        private val HEADER_STRING = "Authorization"


        fun addAuthentication(res: HttpServletResponse, username: String) {
            val JWT = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact()
            res.addHeader(HEADER_STRING, "$TOKEN_PREFIX $JWT")
        }

        fun getAuthentication(request: HttpServletRequest): Authentication? {
            val token = request.getHeader(HEADER_STRING) ?: return null
            // parse the token.
            val user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .body
                    .subject

            return if (user != null)
                UsernamePasswordAuthenticationToken(user, null, emptyList<GrantedAuthority>())
            else
                null
        }
    }

}