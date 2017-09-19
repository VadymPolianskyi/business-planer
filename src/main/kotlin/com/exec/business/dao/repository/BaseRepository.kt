package com.exec.business.dao.repository

import com.exec.business.dao.entity.api.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
/**
 * Author: Vadym Polyanski;
 * Date: 19.09.17;
 * Time: 22:00.
 */
interface BaseRepository<E: BaseEntity> : JpaRepository<E, String>