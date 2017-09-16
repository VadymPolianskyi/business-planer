package com.exec.business.protocol.dto

/**
 * Author: Vadym Polyanski
 * Date: 07.09.17
 * Time: 9:38
 */

data class UserDTO(
        val id: String?,
        val firstName: String?,
        val lastName: String?,
        val age: Int?,
        val sex: String?,
        val email: String?
)