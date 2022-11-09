package com.myunidays.kiterable

expect object IterableFirebaseMessagingService {
    fun isGhostPush(message: RemoteMessage): Boolean
    fun handleMessageReceived(context: Context, message: RemoteMessage): Boolean

    fun handleTokenRefresh()
}
