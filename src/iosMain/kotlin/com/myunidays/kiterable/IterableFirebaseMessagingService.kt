package com.myunidays.kiterable

actual object IterableFirebaseMessagingService {
    actual fun isGhostPush(message: RemoteMessage): Boolean {
        TODO("Not yet implemented")
    }

    actual fun handleMessageReceived(
        context: Context,
        message: RemoteMessage,
    ): Boolean {
        TODO("Not yet implemented")
    }

    actual fun handleTokenRefresh() {
    }
}
