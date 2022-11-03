package com.myunidays.kiterable


actual class IterableApi internal constructor(val android: com.iterable.iterableapi.IterableApi) {
    actual companion object {
        actual fun initialize(config: Configuration): IterableApi {
            com.iterable.iterableapi.IterableApi.initialize(config.context, config.apiKey)
            return instance
        }

        actual fun getInstance(): IterableApi = instance

        actual fun shared(): IterableApi = instance

        private val instance: IterableApi by lazy {
            IterableApi(com.iterable.iterableapi.IterableApi.getInstance())
        }

    }

    actual fun setUserId(userId: String?) = android.setUserId(userId)

    actual fun getPayloadData(key: String): String? = android.getPayloadData(key)

    actual fun getMessages(): List<IterableInAppMessage> = android.inAppManager.messages.map { IterableInAppMessage(it) }
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)

}