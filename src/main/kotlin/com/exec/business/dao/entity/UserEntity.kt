package com.exec.business.dao.entity

import com.exec.business.dao.entity.api.BaseEntity
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 20:45.
 */

@Entity
@Table(name = "user")
class UserEntity(


        override var id : String?,

        @Column(name = "first_name")
        var firstName: String? = null,

        @Column(name = "last_name")
        var lastName: String? = null,

        @Column(name = "age")
        var age: Int? = null,

        @Column(name = "sex")
        var sex: String? = null,

        @Column(name = "email")
        var email: String? = null,

        @Column(name = "password")
        var password: String? = null
) : BaseEntity(id)