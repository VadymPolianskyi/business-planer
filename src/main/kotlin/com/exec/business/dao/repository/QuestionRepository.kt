package com.exec.business.dao.repository

import com.exec.business.dao.entity.BusinessPlanEntity
import com.exec.business.dao.entity.QuestionEntity

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:00.
 */
interface QuestionRepository : BaseRepository<QuestionEntity> {
    fun findByBusinessPlan(businessPlan: BusinessPlanEntity): List<QuestionEntity>
}