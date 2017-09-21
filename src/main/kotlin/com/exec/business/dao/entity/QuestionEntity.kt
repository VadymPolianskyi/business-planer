package com.exec.business.dao.entity

import com.exec.business.dao.entity.api.BaseEntity
import com.exec.business.dao.entity.util.PlanStep
import javax.persistence.*

/**
 * Author: Vadym Polyanski;
 * Date: 20.09.17;
 * Time: 7:39.
 */
@Entity
@Table(name = "question")
class QuestionEntity(
        override var id: String? = null,

        @ManyToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        var business: BusinessEntity?,

        @Column(name = "priority")
        var priority: Int? = null,

        @Enumerated(EnumType.STRING)
        var type: PlanStep

):BaseEntity(id)