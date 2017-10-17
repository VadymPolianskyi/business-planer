package com.exec.business.dao.repository

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.ContactEntity

/**
 * Author: Vadym Polyanski;
 * Date: 15.10.17;
 * Time: 13:54.
 */
interface ContactRepository : BaseRepository<ContactEntity>{
    fun findByPlan(plan: BusinessPlanEntity): List<ContactEntity>
}