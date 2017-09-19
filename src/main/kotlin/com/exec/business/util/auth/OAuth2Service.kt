package com.exec.business.util.auth

import org.springframework.security.oauth2.common.OAuth2AccessToken

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:15.
 */
interface OAuth2Service {

    fun getAccess(userId: String): OAuth2AccessToken

    fun revokeToken(token: String)
}