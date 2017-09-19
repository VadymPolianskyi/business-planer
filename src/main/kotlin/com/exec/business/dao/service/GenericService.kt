package com.exec.business.dao.service

import com.exec.business.dao.entity.api.BaseEntity
import com.exec.business.dao.repository.BaseRepository
import org.springframework.beans.factory.annotation.Autowired

/**
 * Author: Vadym Polyanski;
 * Date: 06.09.17;
 * Time: 22:02.
 */
abstract class GenericService<E : BaseEntity, R : BaseRepository<E>> {

    @Autowired internal
    lateinit var repository: R

    fun save(entity: E): E {
        return repository.save(entity)
    }

    fun delete(id: String) {
        repository.delete(id)
    }

    fun update(entity: E): E {
        return repository.save(entity)
    }

    fun getAll(): List<E> {
        return repository.findAll()
    }

    fun getById(id: String): E {
        return repository.findOne(id)
    }
}