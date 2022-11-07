package com.myunidays.kiterable

expect class IterableInAppManager {

    val messages: List<IterableInAppMessage>
    val inboxMessages: List<IterableInAppMessage>
    val unreadInboxMessagesCount: Int

    fun setAutoDisplayPaused(paused: Boolean)
    fun showMessage(message: IterableInAppMessage, consume: Boolean, clickCallback: IterableUrlCallback)
}

interface IterableUrlCallback {
    fun execute(url: String)
}

interface IterableActionHandler {
    fun execute(data: String?)
}
