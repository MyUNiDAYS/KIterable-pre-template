package com.myunidays.kiterable

actual class IterableApi internal constructor(val android: com.iterable.iterableapi.IterableApi) {
    actual companion object {
        actual fun initialize(config: Configuration): IterableApi {
            com.iterable.iterableapi.IterableApi.initialize(config.context, config.apiKey)
            return internalInstance
        }

        actual fun getInstance(): IterableApi = internalInstance

        actual fun shared(): IterableApi = internalInstance

        private val internalInstance: IterableApi by lazy {
            IterableApi(com.iterable.iterableapi.IterableApi.getInstance())
        }
    }

    actual fun setUserId(userId: String?) = android.setUserId(userId)

    actual fun getPayloadData(key: String): String? = android.getPayloadData(key)
    actual fun getMessages(): List<IterableInAppMessage> = getInAppManager().messages
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual fun getInAppManager(): IterableInAppManager = IterableInAppManager(android.inAppManager)
}
