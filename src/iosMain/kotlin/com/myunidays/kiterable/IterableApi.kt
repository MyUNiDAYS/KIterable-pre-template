package com.myunidays.kiterable

actual class IterableApi internal constructor(val ios: IterableApiImpl) {
    actual companion object {
        private val internalInstance = IterableApiImpl()

        actual fun initialize(config: Configuration): IterableApi {
            internalInstance.initialize(config.apiKey)
            return instance
        }

        actual fun getInstance(): IterableApi = instance

        actual fun shared(): IterableApi = instance

        private val instance: IterableApi by lazy {
            IterableApi(internalInstance)
        }
    }

    actual fun setUserId(userId: String?) = ios.setUserId(userId)
    actual fun getPayloadData(): PayloadData? = ios.getPayloadData()
    actual fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual fun getMessages(): List<IterableInAppMessage> = getInAppManager().messages
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual fun getInAppManager(): IterableInAppManager = ios.inAppManager
    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        onClick: IterableUrlCallback,
    ) = getInAppManager().showMessage(message, consume, onClick)

    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler?) = ios.getAndTrackDeepLink(uri, onCallback)
}

class IterableApiImpl {

    private lateinit var apiKey: String
    lateinit var inAppManager: IterableInAppManager

    fun initialize(key: String) {
        apiKey = key
    }
    // apiKey: iterableApiKey, launchOptions: launchOptions, config: config

    fun setUserId(userId: String?) {
        TODO("need to see how this works")
    }

    fun getPayloadData(): PayloadData? = null

    fun getPayloadData(key: String): String? {
        TODO("need to see how this works")
    }

    fun getMessages(): List<IterableInAppMessage> = TODO("need to see how this works")

    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler?) {
        TODO("need to see how this works")
    }

    // inAppManager
    // .getAndTrack(deeplink: url) { (originalUrl) in
    // .register(token: token)
    // .userId
    // .disableDeviceForCurrentUser()
}
