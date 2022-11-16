package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.RemoteMessage

actual object IterableMessagingService {
    actual fun isGhostPush(message: RemoteMessage): Boolean =
        (message.objectForKey("isGhostPush") as? Boolean) ?: false

    actual fun handleMessageReceived(
        context: Context,
        message: RemoteMessage,
    ): Boolean {
        TODO("Not yet implemented")
    }

    actual fun handleTokenRefresh() {
    }

    fun metadata(fromLaunchOptions: Map<String, Any>) {
    }
}
