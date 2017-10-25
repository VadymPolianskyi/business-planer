package com.exec.business.dao.service

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.ContactEntity
import com.exec.business.dao.repository.ContactRepository
import org.springframework.stereotype.Service

/**
 * Author: Vadym Polyanski;
 * Date: 15.10.17;
 * Time: 13:55.
 */
@Service
class ContactService : GenericService<ContactEntity, ContactRepository>() {

    fun findByPlan(plan: BusinessPlanEntity): List<ContactEntity> {
        return repository.findByPlan(plan)
    }
}