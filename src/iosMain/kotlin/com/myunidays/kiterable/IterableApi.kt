package com.myunidays.kiterable

actual class IterableApi internal constructor(val ios: IterableApiImpl) {
    actual companion object {
        private val internalInstance = IterableApiImpl()

        actual fun initialize(context: Context, apiKey: String, config: IterableConfig): IterableApi {
            internalInstance.initialize(apiKey)
            return instance
        }

        actual fun getInstance(): IterableApi = instance

        actual fun shared(): IterableApi = instance

        private val instance: IterableApi by lazy {
            IterableApi(internalInstance)
        }
    }

    actual fun setUserId(userId: String?) = ios.setUserId(userId)
    actual fun setEmail(email: String?) = ios.setEmail(email)
    actual fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual fun getMessages(): List<IterableInAppMessage> = inAppManager.messages
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        onClick: IterableHelper.IterableUrlCallback,
    ) = inAppManager.showMessage(message, consume, onClick)

    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler) = ios.getAndTrackDeepLink(uri, onCallback)
    actual val payloadData: PayloadData?
        get() = ios.getPayloadData()
    actual val inAppManager: IterableInAppManager
        get() = ios.inAppManager
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

    fun setEmail(email: String?) {
        TODO("need to see how this works")
    }

    fun getPayloadData(): PayloadData? = null

    fun getPayloadData(key: String): String? {
        TODO("need to see how this works")
    }

    fun getMessages(): List<IterableInAppMessage> = TODO("need to see how this works")

    fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler?) {
        TODO("need to see how this works")
    }

    // inAppManager
    // .getAndTrack(deeplink: url) { (originalUrl) in
    // .register(token: token)
    // .userId
    // .disableDeviceForCurrentUser()
}
