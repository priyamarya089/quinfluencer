package com.lastbrand.quinfluencer.domain.request

import com.lastbrand.quinfluencer.domain.Influencer
import com.lastbrand.quinfluencer.domain.Status
import java.time.LocalDateTime

data class CreateInfluencer(
    val userId: Long,
    val socialMediaName: String,
    val orderUrl: String,
    val postUrl: String
) {
    fun getInflencer(createInfluencer: CreateInfluencer): Influencer {
        return Influencer(
            userId = createInfluencer.userId,
            socialMediaName = createInfluencer.socialMediaName,
            orderUrl = createInfluencer.orderUrl,
            postUrl = createInfluencer.postUrl,
            amount = 0.0,
            status = Status.IN_REVIEW,
            createdAt = LocalDateTime.now()
        )
    }
}
