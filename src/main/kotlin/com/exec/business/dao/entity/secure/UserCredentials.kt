package com.exec.business.dao.entity.secure

import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:01.
 */
@Entity
class UserCredentials() : UserDetails {

    @Id
    lateinit var id: String
    lateinit var name: String
    var expired: Boolean = false
    var locked: Boolean = false
    var enabled: Boolean = false
    lateinit var userPassword: String
    @OneToMany
    var authorityList: List<UserAuthority>? = null

    constructor(id: String, name: String, expired: Boolean, locked: Boolean, enabled: Boolean) : this() {
        this.id = id
        this.name = name
        this.expired = expired
        this.locked = locked
        this.enabled = enabled
    }

    override fun getAuthorities(): List<UserAuthority>? {
        return authorityList
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun getUsername(): String {
        return id
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return userPassword
    }

    override fun isAccountNonExpired(): Boolean {
        return !expired
    }

    override fun isAccountNonLocked(): Boolean {
        return !locked
    }
}