package com.exec.business.dao.entity.secure

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:04.
 */
@Entity
class UserAuthority(
        @Id
        private val role: String
) : GrantedAuthority {

    override fun getAuthority(): String {
        return role
    }

}


