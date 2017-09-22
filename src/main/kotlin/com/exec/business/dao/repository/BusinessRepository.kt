package com.exec.business.dao.repository

import com.exec.business.dao.entity.BusinessEntity

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:29.
 */
interface BusinessRepository : BaseRepository<BusinessEntity>{
    fun findByOwner(owner: String): List<BusinessEntity>
}