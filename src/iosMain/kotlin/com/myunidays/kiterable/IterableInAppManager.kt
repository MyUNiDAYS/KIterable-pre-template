package com.myunidays.kiterable

actual class IterableInAppManager internal constructor(val ios: IterableInAppManagerImpl) {
    actual val messages: List<IterableInAppMessage>
        get() = ios.messages.map { IterableInAppMessage(it) }

    actual val inboxMessages: List<IterableInAppMessage>
        get() = ios.inboxMessages.map { IterableInAppMessage(it) }
    actual val unreadInboxMessagesCount: Int
        get() = ios.unreadInboxMessagesCount

    actual fun setAutoDisplayPaused(paused: Boolean) {
        ios.autoDisplayPaused = paused
    }

    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        clickCallback: IterableHelper.IterableUrlCallback,
    ) = ios.showMessage(ios.messages.first { it.messageId == message.messageId }, consume, clickCallback)
}

class IterableInAppManagerImpl {
    val messages: List<IterableInAppMessageImpl> = emptyList()
    val inboxMessages: List<IterableInAppMessageImpl> = emptyList()
    val unreadInboxMessagesCount get() = inboxMessages.count()  //needs to be unread ones
    var autoDisplayPaused: Boolean = false

    fun showMessage(message: IterableInAppMessageImpl, consume: Boolean, clickCallback: IterableHelper.IterableUrlCallback) {
        TODO("Need to implement")
    }
}
