package com.lastbrand.quinfluencer.domain

import java.time.LocalDateTime

data class Influencer(
    val userId: Long,
    val socialMediaName: String,
    val orderUrl: String,
    val postUrl: String,
    val status: Status,
    val amount: Double,
    val createdAt: LocalDateTime,
    val validatedAt: LocalDateTime? = null,
    val invalidatedAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val storeCreditId: String? = null
)

enum class Status {
    IN_REVIEW, VALID, PAID, INVALID
}
