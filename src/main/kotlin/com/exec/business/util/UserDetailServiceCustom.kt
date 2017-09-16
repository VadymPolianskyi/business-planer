package com.exec.business.util

import com.exec.business.dao.repository.UserDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:00.
 */
@Service
class UserDetailServiceCustom : UserDetailsService {

    @Autowired
    private lateinit var userDetailsRepository: UserDetailsRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userId: String): UserDetails {
        return userDetailsRepository.findOne(userId) ?: throw UsernameNotFoundException("There is no username with " + userId)
    }

}