package com.exec.business.dao.service

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.repository.BusinessRepository
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:31.
 */
@Component
open class BusinessService : GenericService<BusinessPlanEntity, BusinessRepository>() {
    fun findByOwner(owner: String): List<BusinessPlanEntity> {
        return repository.findByOwner(owner)
    }
}