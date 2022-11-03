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
    actual fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual fun getMessages(): List<IterableInAppMessage> = ios.getMessages()
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)

}

class IterableApiImpl {

    private lateinit var apiKey: String

    fun initialize(key: String) {
        apiKey = key
    }
    //apiKey: iterableApiKey, launchOptions: launchOptions, config: config

    fun setUserId(userId: String?) {
        TODO("need to see how this works")
    }

    fun getPayloadData(key: String): String? {
        TODO("need to see how this works")
    }

    fun getMessages(): List<IterableInAppMessage> = TODO("need to see how this works")

    //inAppManager
    //.getAndTrack(deeplink: url) { (originalUrl) in
    //.register(token: token)
    //.userId
    //.disableDeviceForCurrentUser()
}
