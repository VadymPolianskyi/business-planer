package com.exec.business.dao.service

import com.exec.business.dao.entity.QuestionEntity
import com.exec.business.dao.repository.QuestionRepository
import org.springframework.stereotype.Component

/**
 * Author: Vadym Polyanski;
 * Date: 12.10.17;
 * Time: 23:01.
 */
@Component
open class QuestionService : GenericService<QuestionEntity, QuestionRepository>()