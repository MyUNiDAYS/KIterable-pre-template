package com.myunidays.kiterable

actual object IterableFirebaseMessagingService {
    actual fun isGhostPush(message: RemoteMessage) = com.iterable.iterableapi.IterableFirebaseMessagingService.isGhostPush(message)

    actual fun handleMessageReceived(
        context: Context,
        message: RemoteMessage,
    ) = com.iterable.iterableapi.IterableFirebaseMessagingService.handleMessageReceived(context, message)

    actual fun handleTokenRefresh() = com.iterable.iterableapi.IterableFirebaseMessagingService.handleTokenRefresh()
}
