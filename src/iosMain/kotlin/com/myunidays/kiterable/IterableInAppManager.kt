package com.myunidays.kiterable

actual class IterableInAppManager internal constructor(val ios: IterableInAppManagerImpl) {
    actual val messages: List<IterableInAppMessage>
        get() = ios.messages
}

class IterableInAppManagerImpl {
    val messages: List<IterableInAppMessage> = emptyList()
}
