package com.myunidays.kiterable

expect class IterableApi {

    companion object {

        fun initialize(context: Context, apiKey: String, config: IterableConfig): IterableApi

        fun getInstance(): IterableApi
        fun shared(): IterableApi
    }

    val payloadData: PayloadData?
    val inAppManager: IterableInAppManager
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessage>
    fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableHelper.IterableUrlCallback)
    fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler)
}
