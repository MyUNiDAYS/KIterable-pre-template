package com.myunidays.kiterable

actual class IterableInAppMessage internal constructor(val ios: IterableInAppMessageImpl) {

}

data class IterableInAppMessageImpl(
    val messageId: String,
//    val content: Content,
//    val customPayload: JSONObject,
//    val createdAt: Date,
//    val expiresAt: Date,
//    val trigger: Trigger,
//    val priorityLevel: Double,
//    val inboxMetadata: InboxMetadata,
//    val campaignId: Long,
)
