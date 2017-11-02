package com.exec.business.dao.repository

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.UserEntity

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:29.
 */
interface BusinessRepository : BaseRepository<BusinessPlanEntity>{
    fun findByOwner(owner: UserEntity): List<BusinessPlanEntity>
}