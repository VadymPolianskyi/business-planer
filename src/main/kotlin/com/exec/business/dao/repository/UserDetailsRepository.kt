package com.exec.business.dao.repository

import com.exec.business.dao.entity.secure.UserCredentials
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Author: Vadym Polyanski;
 * Date: 16.09.17;
 * Time: 23:01.
 */
interface UserDetailsRepository : JpaRepository<UserCredentials, String>