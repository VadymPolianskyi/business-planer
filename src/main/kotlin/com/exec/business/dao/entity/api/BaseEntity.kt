package com.exec.business.dao.entity.api

import org.hibernate.annotations.GenericGenerator
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Author: Vadym Polyanski;
 * Date: 19.09.17;
 * Time: 21:55.
 */
@MappedSuperclass
open class BaseEntity(
        @Id
        @GenericGenerator(name = "uuid_generator", strategy = "uuid2")
        @GeneratedValue(generator = "uuid_generator")
        var id: String? = null
)