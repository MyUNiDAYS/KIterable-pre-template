package com.myunidays.kiterable

actual class IterableInAppManager internal constructor(val android: com.iterable.iterableapi.IterableInAppManager) {
    actual val messages: List<IterableInAppMessage>
        get() = android.messages.map { IterableInAppMessage(it) }
}
