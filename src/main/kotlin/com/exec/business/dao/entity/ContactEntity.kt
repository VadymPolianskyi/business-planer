package com.exec.business.dao.entity

import com.exec.business.dao.entity.api.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Author: Vadym Polyanski;
 * Date: 20.09.17;
 * Time: 7:45.
 */
@Entity
@Table(name = "contact")
class ContactEntity(
        override var id: String? = null,

        @Column(name = "name")
        var name: String,

        @Column(name = "phone_number")
        var phoneNumber: String,

        @Column(name = "email")
        var email: String,

        @Column(name = "role")
        var role: String
) :BaseEntity(id)