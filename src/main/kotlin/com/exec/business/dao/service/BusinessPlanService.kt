package com.exec.business.dao.service

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.UserEntity
import com.exec.business.dao.repository.BusinessRepository
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 22.09.17;
 * Time: 21:31.
 */
@Component
open class BusinessPlanService : GenericService<BusinessPlanEntity, BusinessRepository>() {
    fun findByOwner(owner: UserEntity): List<BusinessPlanEntity> {
        return repository.findByOwner(owner)
    }
}