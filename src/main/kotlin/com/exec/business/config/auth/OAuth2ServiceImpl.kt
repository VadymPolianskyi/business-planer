package com.exec.business.config.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.OAuth2Request
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.*

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:17.
 */
@Service
class OAuth2ServiceImpl : OAuth2Service {

    @Autowired
    private lateinit var tokenStore: TokenStore
    @Autowired
    private lateinit var configuration: AuthorizationServerEndpointsConfiguration
    @Autowired
    private lateinit var userDetailsService: UserDetailsService


    override fun revokeToken(token: String) {
        val accessToken = tokenStore.readAccessToken(token)
        tokenStore.removeAccessToken(accessToken)
    }

    override fun getAccess(userId: String): OAuth2AccessToken {
        val requestParameters = HashMap<String, String>()
        val extensionProperties = HashMap<String, Serializable>()

        val responseTypes = HashSet<String>()
        responseTypes.add("code")

        val scopes = Arrays.asList("read", "write")
        // Authorities
        val authorities = ArrayList<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))

        val oauth2Request = OAuth2Request(requestParameters, "my-trusted-client", authorities, true, HashSet(scopes), HashSet(listOf("oauth2-resource")), null, responseTypes, extensionProperties)

        val authenticationToken = UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(userId), "N/A", authorities)

        val auth = OAuth2Authentication(oauth2Request, authenticationToken)

        val tokenService = configuration.endpointsConfigurer.tokenServices

        return tokenService.createAccessToken(auth)
    }

}