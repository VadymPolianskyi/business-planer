package com.exec.business.dao.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 20:45.
 */

@Entity
class UserEntity(
        @Id
        @GenericGenerator(name = "uuid_generator", strategy = "uuid2")
        @GeneratedValue(generator = "uuid_generator")
        var id: String?,

        @Column(name = "first_name")
        var firstName: String?,

        @Column(name = "last_name")
        var lastName: String?,

        @Column(name = "age")
        var age: Int?,

        @Column(name = "sex")
        var sex: String?,

        @Column(name = "email")
        var email: String?,

        @Column(name = "password")
        var password: String?
)