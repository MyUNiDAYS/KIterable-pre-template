package com.myunidays.kiterable

actual class IterableInAppMessage internal constructor(val ios: IterableInAppMessageImpl) {
    val messageId: String = ios.messageId
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
