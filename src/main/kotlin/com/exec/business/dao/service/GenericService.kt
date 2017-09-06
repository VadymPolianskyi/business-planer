package com.exec.business.dao.service

import java.io.Serializable

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:02.
 */
interface GenericService<in ID: Serializable, T> {

    fun save(entity: T): T?

    fun update(entity: T): T?

    fun delete(id: ID)

    fun findById(id: ID): T?

    fun findAll(): List<T>
}