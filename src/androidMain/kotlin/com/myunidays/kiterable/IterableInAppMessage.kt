package com.myunidays.kiterable


actual class IterableInAppMessage internal constructor(android: com.iterable.iterableapi.IterableInAppMessage) {
    val messageId = android.messageId
    actual val customPayload: Payload = android.customPayload
}
