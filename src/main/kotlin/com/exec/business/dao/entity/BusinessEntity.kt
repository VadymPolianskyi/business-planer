package com.exec.business.dao.entity

import com.exec.business.dao.entity.api.BaseEntity
import javax.persistence.*

/**
 * Author: Vadym Polyanski;
 * Date: 20.09.17;
 * Time: 7:32.
 */
@Entity
@Table(name = "business")
class BusinessEntity(
        override var id : String? = null,

        @Column(name = "name")
        var name: String? = null,

        @Column(name = "description")
        var description: String? = null,

        @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        var owner: UserEntity? = null,

        @OneToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        var questions: List<QuestionEntity>? = null

): BaseEntity(id)