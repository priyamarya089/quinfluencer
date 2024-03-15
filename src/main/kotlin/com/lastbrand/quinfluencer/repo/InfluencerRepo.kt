package com.lastbrand.quinfluencer.repo

import com.lastbrand.commons.temporal.util.UniTemporalDateTimeUtil
import com.lastbrand.quinfluencer.domain.Influencer
import com.lastbrand.repo.exposed.column.datetime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class InfluencerRepo {
    fun create(influencer: Influencer): Influencer {
        InfluencerTable.insert {
            it[id] = -1
            it[userId] = influencer.userId
            it[socialMediaName] = influencer.socialMediaName
            it[orderUrl] = influencer.orderUrl
            it[postUrl] = influencer.postUrl
            it[status] = influencer.status.toString()
            it[amount] = influencer.amount
            it[createdAt] = UniTemporalDateTimeUtil.getUTCDateTimeFromLocalDateTime(influencer.createdAt)
            it[validatedAt] =
                influencer.validatedAt?.let { UniTemporalDateTimeUtil.getUTCDateTimeFromLocalDateTime(it) }
            it[invalidateAt] =
                influencer.invalidatedAt?.let { UniTemporalDateTimeUtil.getUTCDateTimeFromLocalDateTime(it) }
            it[updatedAt] = influencer.updatedAt?.let { UniTemporalDateTimeUtil.getUTCDateTimeFromLocalDateTime(it) }
            it[storeCreditId] = influencer.storeCreditId?.let { it }
        }
        return influencer
    }
}

object InfluencerTable : Table("quinfluencer.influencer") {
    val id = long("id")
    val userId = long("user_id")
    val socialMediaName = varchar("social_media_name", 127)
    val postUrl = varchar("post_url", 127)
    val orderUrl = varchar("order_url", 127)
    val status = varchar("status", 127)
    val amount = double("amount")
    val createdAt = datetime("created_at")
    val validatedAt = datetime("confirmed_at").nullable()
    val invalidateAt = datetime("cancelled_at").nullable()
    val updatedAt = datetime("updated_at").nullable()
    val storeCreditId = varchar("store_credit_id", 127).nullable()

    override val primaryKey = PrimaryKey(id)
}